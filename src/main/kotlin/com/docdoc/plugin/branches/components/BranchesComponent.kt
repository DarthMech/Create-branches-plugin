package com.docdoc.plugin.branches.components

import com.intellij.openapi.components.ProjectComponent
import com.intellij.openapi.project.Project

class BranchesComponent(private val project: Project) : ProjectComponent {
//    private var branchesWidget: BranchesStatusBarWidget? = null

    // ---------------------------------------- ProjectComponent ------------------------------------------------------
    override fun getComponentName(): String = BranchesComponent::class.java.name

    override fun projectOpened() {
//        branchesWidget = BranchesStatusBarWidget(project)
//
//        val statusBar = WindowManager.getInstance().getStatusBar(project)
//
//        statusBar?.let {
//            it.addWidget(branchesWidget!!,
//                    "before ReadOnlyAttribute",
//                    project)
//        }
    }

    override fun projectClosed() {}

    override fun initComponent() {}

    override fun disposeComponent() {}

}