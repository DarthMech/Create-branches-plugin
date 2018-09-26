package com.docdoc.plugin.branches.components

import com.docdoc.plugin.branches.BranchesStatusBarWidget
import com.intellij.openapi.components.ProjectComponent
import com.intellij.openapi.project.Project
import com.intellij.openapi.wm.WindowManager

class BranchesComponent(private val project: Project) : ProjectComponent {
    private var branchesWidget: BranchesStatusBarWidget? = null

    // ---------------------------------------- ProjectComponent ------------------------------------------------------
    override fun getComponentName(): String {
        return BranchesComponent::class.java.name
    }

    override fun projectOpened() {
        branchesWidget = BranchesStatusBarWidget(project)
        val statusBar = WindowManager.getInstance().getStatusBar(project)
        statusBar?.let {
            statusBar.addWidget(branchesWidget!!,
                    "before ReadOnlyAttribute",
                    project)
        }
    }

    override fun projectClosed() {}

    override fun initComponent() {}

    override fun disposeComponent() {}
}