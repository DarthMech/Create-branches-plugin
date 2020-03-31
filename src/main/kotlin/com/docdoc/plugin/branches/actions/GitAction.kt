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

        presentation.isEnabled = true
    }

}