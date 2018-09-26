package com.docdoc.plugin.branches.services

import git4idea.commands.Git
import git4idea.commands.GitCommandResult
import git4idea.commands.GitLineHandlerListener
import git4idea.repo.GitRepository

interface ExtensionGit : Git {
    fun checkoutNewBranch(repository: GitRepository,
                          branchName: String,
                          startPoint: String?,
                          listener: GitLineHandlerListener?): GitCommandResult
}