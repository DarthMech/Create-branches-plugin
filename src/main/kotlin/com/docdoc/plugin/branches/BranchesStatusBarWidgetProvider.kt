package com.docdoc.plugin.branches

import com.intellij.openapi.project.Project
import com.intellij.openapi.wm.StatusBarWidget
import com.intellij.openapi.wm.StatusBarWidgetProvider

class BranchesStatusBarWidgetProvider : StatusBarWidgetProvider {

    override fun getWidget(project: Project): StatusBarWidget = BranchesStatusBarWidget(project)

    override fun getAnchor(): String = "before ReadOnlyAttribute"

}