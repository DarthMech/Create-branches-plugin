package com.docdoc.plugin.branches.services

import git4idea.commands.*
import git4idea.repo.GitRepository

class ExtensionGitImpl : GitImpl(), ExtensionGit {

    override fun checkoutNewBranch(
            repository: GitRepository,
            branchName: String,
            startPoint: String?,
            listener: GitLineHandlerListener?
    ): GitCommandResult {

        val h = GitLineHandler(repository.project, repository.root, GitCommand.CHECKOUT.readLockingCommand())
        h.setSilent(false)
        h.setStdoutSuppressed(false)
        h.addParameters("-b")
        h.addParameters(branchName)

        startPoint?.let {
            if (startPoint.isEmpty()) {
                h.addParameters(startPoint)
            }
        }

        listener?.let {
            h.addLineListener(it)
        }

        return runCommand(h)
    }

}