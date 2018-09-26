package com.docdoc.plugin.branches.actions

import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.PlatformDataKeys
import com.intellij.openapi.project.DumbAwareAction
import com.intellij.openapi.project.Project

abstract class GitAction : DumbAwareAction() {

    override fun update(e: AnActionEvent) {
        val presentation = e.presentation
        val project = e.getData<Project>(PlatformDataKeys.PROJECT)
        if (project == null || project.isDisposed) {
            presentation.isEnabled = false
            presentation.isVisible = false
            return
        }

        presentation.isEnabled = isEnabled(e)
    }

    /**
     * Checks if this action should be enabled.
     * Called in [.update], so don't execute long tasks here.
     * @return true if the action is enabled.
     */
    protected fun isEnabled(event: AnActionEvent): Boolean {
        return true
    }
}