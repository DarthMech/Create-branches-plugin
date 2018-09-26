package com.docdoc.plugin.branches.actions

class CreateFeatureBranchAction : BaseBranchAction(BranchesType.FEATURE) {
    init {
        templatePresentation.text = "Feature"
    }
}