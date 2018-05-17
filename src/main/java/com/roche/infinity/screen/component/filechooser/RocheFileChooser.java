/**
 * 
 */
package com.roche.infinity.screen.component.filechooser;

import java.io.File;

import javax.swing.JFileChooser;

/**
 * @author grebonfe
 *
 */
public class RocheFileChooser extends JFileChooser{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public RocheFileChooser() {
		super();
		this.setFileSelectionMode(DIRECTORIES_ONLY);
	}
	
	public RocheFileChooser(File defaultPath) {
		super(defaultPath);
		
		this.setFileSelectionMode(DIRECTORIES_ONLY);
	}
}
