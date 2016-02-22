/*
* Created by Oleg Volkov
*
* Copyright (c) 2016 Oleg Volkov. All Rights Reserved.
*/
package application.model;

import javafx.scene.control.TreeItem;

/**
* Model class for testing tree view
*
* @version 1.01 22 Feb 2016
* @author Oleg Volkov
*/
public class TreeViewModel {
	
	/* Tree view root element*/
	private TreeItem<String> root;
	
	/* Tree view constructor and initializer */
	public TreeViewModel() {
		// TODO Auto-generated constructor stub
		
		// Initialize root element
		this.root = new TreeItem<String>("TreeViewExample");
		this.root.setExpanded(false);
		
		// Initialize first level
		for (int i1 = 0; i1 < 5; i1++) {
			TreeItem<String> rootLevel1 = new TreeItem<String>("TreeItem on Level1 - " + (i1+1));
			rootLevel1.setExpanded(true);
			
			// Initialize second level
			for (int i2 = 0; i2 < 4; i2++) {
				TreeItem<String> rootLevel2 = new TreeItem<String>("TreeItem on Level2 - " + (i2+1));
				rootLevel2.setExpanded(true);
				
				// Initialize third level
				for (int i3 = 0; i3 < 3; i3++) {
					TreeItem<String> rootLevel3 = new TreeItem<String>("TreeItem on Level3 - " + (i2+1));
					
					// Adding to parent
					rootLevel2.getChildren().add(rootLevel3);
				}
				
				// Adding to parent
				rootLevel1.getChildren().add(rootLevel2);
			}
			
			// Adding to parent
			root.getChildren().add(rootLevel1);
		}
	}
	
	/* Getter of root element */
	public TreeItem<String> getRoot() {
		return root;
	}

}
