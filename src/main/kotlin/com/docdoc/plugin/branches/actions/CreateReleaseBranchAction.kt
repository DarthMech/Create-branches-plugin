package com.docdoc.plugin.branches.actions

import com.docdoc.plugin.branches.services.ExtensionGit
import com.docdoc.plugin.branches.ui.release.CreateReleaseBranchView
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.components.ServiceManager
import com.intellij.openapi.ui.DialogBuilder
import git4idea.branch.GitBranchUtil

class CreateReleaseBranchAction : BaseBranchAction(BranchesType.RELEASE) {
    override fun actionPerformed(event: AnActionEvent) {
        val view = CreateReleaseBranchView()

        val builder = DialogBuilder()
        builder.setTitle("Создать рилизную ветку")
        builder.setCenterPanel(view.mainPanel)
        builder.setPreferredFocusComponent(view.idTextField)

        val exitCode = builder.show()
        if (exitCode == 0) {
            val repo = GitBranchUtil.getCurrentRepository(event.project!!)
            val service = ServiceManager.getService(ExtensionGit::class.java)
            service.checkoutNewBranch(repo!!, "", null, null)
            repo.update()
        }
    }
}