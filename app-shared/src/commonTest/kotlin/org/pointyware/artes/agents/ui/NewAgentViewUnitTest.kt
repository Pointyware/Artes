package org.pointyware.artes.agents.ui

import androidx.compose.ui.semantics.SemanticsProperties
import androidx.compose.ui.semantics.getOrNull
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.SemanticsMatcher
import androidx.compose.ui.test.SemanticsNodeInteraction
import androidx.compose.ui.test.SemanticsNodeInteractionsProvider
import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.onAllNodesWithText
import androidx.compose.ui.test.onFirst
import androidx.compose.ui.test.onLast
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.compose.ui.test.runComposeUiTest
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

@OptIn(ExperimentalTestApi::class)
class NewAgentViewUnitTest {

    private val SemanticsNodeInteractionsProvider.agentNameField: SemanticsNodeInteraction
        get() = onNodeWithText("Agent Name")
    private val SemanticsNodeInteractionsProvider.hostSelector: SemanticsNodeInteraction
        get() = onAllNodesWithText("Select an Option").onFirst()
    private val SemanticsNodeInteractionsProvider.modelSelector: SemanticsNodeInteraction
        get() = onAllNodesWithText("Select an Option").onLast()
    private val SemanticsNodeInteractionsProvider.submitButton: SemanticsNodeInteraction
        get() = onNodeWithText("Submit")

    private fun SemanticsNodeInteraction.assertEditableTextEquals(
        expected: String
    ): SemanticsMatcher {
        val propertyName = SemanticsProperties.EditableText.name
        return SemanticsMatcher(
            "$propertyName = [$expected]"
        ) { node ->
            node.config.getOrNull(SemanticsProperties.EditableText)?.text == expected
        }
    }

    private var actualName: String? = null
    private var actualHost: Int? = null
    private var actualModel: Int? = null
    private var actualInstructions: String? = null

    @BeforeTest
    fun setUp() {
        actualName = null
        actualHost = null
        actualModel = null
        actualInstructions = null
    }

    @AfterTest
    fun tearDown() {

    }

    @Test
    fun model_name_can_be_changed() = runComposeUiTest {
        /*
        Given: An empty new agent view state,
        And: A new agent view
         */
        val state = NewAgentViewState(
            agentName = "",
            hosts = emptyList(),
            selectedHost = null,
            hostModels = emptyList(),
            selectedModel = null,
            instructions = ""
        )

        /*
        When: A new agent view is displayed with given state
         */
        setContent {
            NewAgentView(
                state = state,
                onSelectHost = {},
                onSubmit = { _, _, _, _ -> }
            )
        }

        /*
        Then: The model name field is empty
        And: the host selector is disabled
        And: the model selector is disabled
         */
        agentNameField.assertEditableTextEquals("")
        hostSelector.assertIsNotEnabled()
        modelSelector.assertIsNotEnabled()

        /*
        When: The user enters a model name
         */
        agentNameField.performTextInput("agent1")

        /*
        Then: The model name is updated
         */
        onNodeWithText("agent1")
            .assertExists()
    }

    @Test
    fun model_host_can_be_selected() = runComposeUiTest {
        /*
        Given: a new agent view state with a non-empty name, and two hosts
        And: no host is selected
         */
        val state = NewAgentViewState(
            agentName = "Some agent",
            hosts = listOf("host1", "host2"),
            selectedHost = null,
            hostModels = emptyList(),
            selectedModel = null,
            instructions = ""
        )

        /*
        When: A new agent view is displayed with given state
         */
        setContent {
            NewAgentView(
                state = state,
                onSelectHost = { actualHost = it},
                onSubmit = { _, _, _, _ ->
                    throw Exception("onSubmit should not be called")
                }
            )
        }

        /*
        Then: The agent name field displays the given name
        And: The host selector is enabled
        And: the model selector is disabled
         */
        agentNameField.assertEditableTextEquals("Some agent")
        hostSelector.assertIsEnabled()
        modelSelector.assertIsNotEnabled()

        /*
        When: The user opens the host selector
        And: selects a host
         */
        hostSelector.performClick()
        onNodeWithText("host1").performClick()

        /*
        Then: The host selected callback is invoked with 0
         */
        assertEquals(0, actualHost)
    }

    @Test
    fun agent_model_can_be_selected() = runComposeUiTest {
        /*
        Given: a new agent view state with a non-empty name, and two hosts
        And: the first host is selected
        And: two models are available
        And: no model is selected
         */
        val state = NewAgentViewState(
            agentName = "Some agent",
            hosts = listOf("host1", "host2"),
            selectedHost = 0,
            hostModels = listOf("model1", "model2"),
            selectedModel = null,
            instructions = ""
        )

        /*
        When: A new agent view is displayed with given state
         */
        setContent {
            NewAgentView(
                state = state,
                onSelectHost = { throw Exception("onSelectHost should not be called") },
                onSubmit = { _, _, _, _ ->
                    throw Exception("onSubmit should not be called")
                }
            )
        }

        /*
        Then: The agent name field is empty
        And: The host selector is enabled
        And: the model selector is enabled
        And: the submit button is disabled
         */
        agentNameField.assertEditableTextEquals("")
        hostSelector.assertIsEnabled()
        modelSelector.assertIsEnabled()
        submitButton.assertIsNotEnabled()

        /*
        When: The user opens the model selector
        And: The user selects a model
         */
        modelSelector.performClick()
        onNodeWithText("model1").performClick()

        /*
        Then: The selected model is reflected
        And: the submit button is enabled
         */
        onNodeWithText("model1")
            .assertExists()
        submitButton.assertIsEnabled()

        /*
        When: The user taps the submit button
         */
        onNodeWithText("Submit").performClick()

        /*
        Then: The onSubmit callback is called with the agent name, host, model, and instructions
         */
        assertEquals("agent1", actualName)
        assertEquals(0, actualHost)
        assertEquals(1, actualModel)
        assertEquals("", actualInstructions)
    }
}
