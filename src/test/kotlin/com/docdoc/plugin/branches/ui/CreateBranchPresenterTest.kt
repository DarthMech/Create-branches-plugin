package com.docdoc.plugin.branches.ui

import com.docdoc.plugin.branches.actions.BranchesType

import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.gherkin.Feature
import kotlin.test.assertEquals

object CreateBranchPresenterSpekTest : Spek({
    Feature("Test feature branch") {
        val presenter = CreateBranchPresenter(BranchesType.FEATURE)

        Scenario("Feature branch") {
            Then("check type") {
                assertEquals(BranchesType.FEATURE, presenter.branchType)
            }

            Then("empty branch name") {
                val name = presenter.getBranchName("", "", "")
                assertEquals("feature/DD-/", name)
            }
        }
    }

    Feature("Test hotfix branch") {
        val presenter = CreateBranchPresenter(BranchesType.HOT_FIX)

        Scenario("Hotfix branch") {
            Then("check type") {
                assertEquals(BranchesType.HOT_FIX, presenter.branchType)
            }

            Then("empty branch name") {
                val name = presenter.getBranchName("", "", "")
                assertEquals("fix/DD-/", name)
            }
        }
    }

})