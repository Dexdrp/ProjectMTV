package view.derp;

import view.QuestionPanel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.MultipleSelectionModel;

public class SelectionModel extends MultipleSelectionModel<QuestionPanel> {
	
	@Override
	public ObservableList<Integer> getSelectedIndices() {
		return FXCollections.observableArrayList();
	}

	@Override
	public ObservableList<QuestionPanel> getSelectedItems() {
		return FXCollections.observableArrayList();
	}

	@Override
	public void selectAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void selectFirst() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void selectIndices(int arg0, int... arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void selectLast() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clearAndSelect(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clearSelection() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clearSelection(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isSelected(int arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void select(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void select(QuestionPanel arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void selectNext() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void selectPrevious() {
		// TODO Auto-generated method stub
		
	}
	
}
