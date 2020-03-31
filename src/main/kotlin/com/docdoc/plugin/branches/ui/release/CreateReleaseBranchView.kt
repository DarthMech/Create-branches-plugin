package com.docdoc.plugin.branches.ui.release

import com.docdoc.plugin.branches.actions.BranchesType
import com.docdoc.plugin.branches.ui.CreateBranchPresenter
import com.intellij.openapi.ui.ComboBox
import com.intellij.ui.layout.CCFlags
import com.intellij.ui.layout.panel
import java.awt.Dimension
import java.awt.event.KeyEvent
import java.awt.event.KeyListener
import javax.swing.JLabel
import javax.swing.JTextField

class CreateReleaseBranchView {

    private val presenter: CreateBranchPresenter = CreateBranchPresenter(BranchesType.RELEASE)

    val idTextField = JTextField("")
    private val exampleLabel = JLabel("${presenter.branchType}/JOB-")
    private val branchNameLabel = JLabel("${presenter.branchType}/JOB-")
    private val releaseMajorTextField = JTextField("")
    private val releaseMinorTextField = JTextField("")
    private val releasePatchTextField = JTextField("")
    private val projectTypeComboBox = ComboBox(arrayOf("JOB", "SERV"))

    val mainPanel = panel {
        row { exampleLabel(CCFlags.grow, CCFlags.push) }
        row(JLabel("Project: ")) { projectTypeComboBox(CCFlags.grow, CCFlags.push) }
        row(JLabel("ID: ")) { idTextField(CCFlags.pushX, CCFlags.push) }
        row(JLabel("Version: ")) {
            releaseMajorTextField(CCFlags.grow, CCFlags.push)
            releaseMinorTextField(CCFlags.grow, CCFlags.push)
            releasePatchTextField(CCFlags.grow, CCFlags.push)
        }

        row { branchNameLabel(CCFlags.grow, CCFlags.push) }
    }

    private val listener = object : KeyListener {
        override fun keyTyped(e: KeyEvent?) {
        }

        override fun keyPressed(e: KeyEvent?) {
        }

        override fun keyReleased(e: KeyEvent?) {
            branchNameLabel.text = getBranchName()
        }
    }

    init {
        mainPanel.preferredSize = Dimension(400, 100)

        projectTypeComboBox.addActionListener {
            exampleLabel.text = "${presenter.branchType}/${projectTypeComboBox.selectedItem as String}-"
            branchNameLabel.text = getBranchName()
        }

        idTextField.addKeyListener(listener)
        releaseMajorTextField.addKeyListener(listener)
        releaseMinorTextField.addKeyListener(listener)
        releasePatchTextField.addKeyListener(listener)
    }

    fun getBranchName() = presenter.getBranchName(
            projectTypeComboBox.selectedItem as String,
            idTextField.text,
            releaseMajorTextField.text + "." + releaseMinorTextField.text + "." + releasePatchTextField.text
    )
}