package com.docdoc.plugin.branches

import com.docdoc.plugin.branches.actions.CreateFeatureBranchAction
import com.docdoc.plugin.branches.actions.CreateFixBranchAction
import com.intellij.openapi.actionSystem.ActionGroup
import com.intellij.openapi.actionSystem.DefaultActionGroup
import com.intellij.openapi.actionSystem.impl.SimpleDataContext
import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.popup.ListPopup
import com.intellij.openapi.wm.StatusBar
import com.intellij.openapi.wm.StatusBarWidget
import com.intellij.ui.popup.PopupFactoryImpl
import com.intellij.util.Consumer
import java.awt.event.MouseEvent

class BranchesStatusBarWidget(private val project: Project) : StatusBarWidget {
    private var presentation: BranchesWidgetPresentation? = null
    private var statusBar: StatusBar? = null

    private var labelText = "DocDoc"
    private val toolTip = "Создать ветки"

    override fun ID(): String = BranchesStatusBarWidget::class.java.name

    override fun getPresentation(type: StatusBarWidget.PlatformType): StatusBarWidget.WidgetPresentation {
        if (presentation == null) {
            presentation = BranchesWidgetPresentation()
        }

        return presentation!!
    }

    override fun install(statusBar: StatusBar) {
        this.statusBar = statusBar
    }

    override fun dispose() {
    }

    // ------------------------------------------- inner methods ------------------------------------------------------
    private fun getWidgetPopupStep(): ListPopup {
        return PopupFactoryImpl.ActionGroupPopup("Menu",
                getActions(),
                SimpleDataContext.getProjectContext(project),
                false,
                false,
                true,
                true,
                null,
                -1,
                null,
                null)
    }

    private fun getActions(): ActionGroup {
        val group = DefaultActionGroup()
        group.add(CreateFeatureBranchAction())
        group.add(CreateFixBranchAction())
        return group
    }

    private inner class BranchesWidgetPresentation : StatusBarWidget.MultipleTextValuesPresentation {
        override fun getPopupStep(): ListPopup? {
            return getWidgetPopupStep()
        }

        override fun getSelectedValue(): String? {
            return labelText
        }

        override fun getTooltipText(): String? {
            return toolTip
        }

        // ------------------------------------
        override fun getMaxValue(): String {
            return ""
        }

        override fun getClickConsumer(): Consumer<MouseEvent>? {
            return null
        }
    }
}