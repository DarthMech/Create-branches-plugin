package com.docdoc.plugin.branches

import com.docdoc.plugin.branches.actions.CreateFeatureBranchAction
import com.docdoc.plugin.branches.actions.CreateFixBranchAction
import com.docdoc.plugin.branches.actions.CreateReleaseBranchAction
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

    override fun ID(): String = BranchesStatusBarWidget::class.java.name

    override fun getPresentation(): StatusBarWidget.WidgetPresentation {
        if (presentation == null) {
            presentation = BranchesWidgetPresentation()
        }

        return presentation!!
    }


    override fun install(statusBar: StatusBar) {
    }

    override fun dispose() {
    }

    // ------------------------------------------- inner methods ------------------------------------------------------
    private fun getWidgetPopupStep(): ListPopup {
        return PopupFactoryImpl.ActionGroupPopup(
                "Menu",
                getActions(),
                SimpleDataContext.getProjectContext(project),
                false,
                false,
                true,
                true,
                null,
                3,
                null,
                null
        )
    }

    private fun getActions(): ActionGroup {

        val group = DefaultActionGroup()
        group.add(CreateFeatureBranchAction().apply {
            templatePresentation.text = "Feature"
        })
        group.add(CreateFixBranchAction().apply {
            templatePresentation.text = "HotFix"
        })
        group.add(CreateReleaseBranchAction().apply {
            templatePresentation.text = "Release"
        })
        return group

    }

    private inner class BranchesWidgetPresentation : StatusBarWidget.MultipleTextValuesPresentation {
        override fun getPopupStep(): ListPopup = getWidgetPopupStep()

        override fun getShortcutText(): String? = null

        override fun getSelectedValue(): String = "Create branch"

        override fun getTooltipText(): String = "Создать ветку по заданному шабллону"

        override fun getClickConsumer(): Consumer<MouseEvent>? = null
    }

}