package com.docdoc.plugin.branches.ui

import com.intellij.openapi.ui.ComboBox
import com.intellij.ui.layout.CCFlags
import com.intellij.ui.layout.panel
import java.awt.Dimension
import java.awt.event.KeyEvent
import java.awt.event.KeyListener
import javax.swing.*

class CreateBranchView(branchType: String)  {

    private val presenter: CreateBranchPresenter = CreateBranchPresenter(branchType)

    val idTextField = JTextField("")
    private val exampleLabel = JLabel("${presenter.branchType}/MOB-/")
    private val branchNameLabel = JLabel("${presenter.branchType}/MOB-/")
    private val labelTextField = JTextField("")
    private val projectTypeComboBox = ComboBox(arrayOf("MOB", "DD", "OP"))

    val mainPanel = panel {
        row { exampleLabel(CCFlags.grow, CCFlags.push) }
        row(JLabel("Project: ")) { projectTypeComboBox(CCFlags.grow, CCFlags.push) }
        row(JLabel("ID: ")) { idTextField(CCFlags.pushX, CCFlags.push) }
        row(JLabel("Label: ")) { labelTextField(CCFlags.grow, CCFlags.push) }
        row { branchNameLabel(CCFlags.grow, CCFlags.push) }
    }

    private val listener =  object : KeyListener {
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
            exampleLabel.text = "${presenter.branchType}/${projectTypeComboBox.selectedItem as String}-/"
            branchNameLabel.text = getBranchName()
        }

        idTextField.addKeyListener(listener)
        labelTextField.addKeyListener(listener)
    }

    fun getBranchName() = presenter.getBranchName(
            projectTypeComboBox.selectedItem as String,
            idTextField.text,
            labelTextField.text
    )
}