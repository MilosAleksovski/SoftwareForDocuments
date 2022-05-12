package dsw.rudok.app.gui.swing.controllers;

import dsw.rudok.app.AppCore;
import dsw.rudok.app.ErrorHandler.ErrorTypes;
import dsw.rudok.app.gui.swing.view.GlavniFrame;
import dsw.rudok.app.repository.Node.RuNode;
import dsw.rudok.app.repository.workspace.Document;
import dsw.rudok.app.repository.workspace.Page;
import dsw.rudok.app.repository.workspace.Project;
import dsw.rudok.app.repository.workspace.Workspace;
import dsw.rudok.app.repository.workspace.slot.Slot;

import java.awt.event.ActionEvent;

public class NewSelectionAction extends AbstractRuDokAction {
    public NewSelectionAction() {
        putValue(SMALL_ICON, loadIcon("slike3/cursor.png"));
        putValue(NAME, "New Selection");
        putValue(SHORT_DESCRIPTION, "New Selection");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(GlavniFrame.getInstance().getTree().selectedPath()==null)
            AppCore.getInstance().getErrHandler().generateError(ErrorTypes.PAGEERROR);
        else {
            RuNode selected = GlavniFrame.getInstance().getTree().selectedItem();
            if (selected instanceof Slot || selected instanceof Document || selected instanceof Project || selected instanceof Workspace)
                AppCore.getInstance().getErrHandler().generateError(ErrorTypes.NOTPAGESELECTED,selected);
            else {
                ((Page)selected).startSelectState();
            }
        }
    }
}
