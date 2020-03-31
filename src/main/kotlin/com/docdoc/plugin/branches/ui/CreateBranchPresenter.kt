package com.docdoc.plugin.branches.ui

class CreateBranchPresenter(val branchType: String) {

    fun getBranchName(
            project: String,
            id: String,
            label: String
    ): String {
        val extendLabel = if (label.isNotEmpty()) {
            "/$label"
        } else {
            ""
        }

        return "$branchType/$project-$id$extendLabel"
    }
}