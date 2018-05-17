/**
 * 
 */
package com.roche.infinity.install4j.component.filechooser;

import javax.swing.JComponent;

import com.roche.infinity.install4j.wrapper.filechooser.RocheFileChooserWrapper;

/**
 * @author grebonfe
 *
 */
public class RocheFileChooser extends RocheFileChooserWrapper{
	String defaultPath;
	
	/**
	 * @return the defaultPath
	 */
	public String getDefaultPath() {
		return defaultPath;
	}

	/**
	 * @param defaultPath the defaultPath to set
	 */
	public void setDefaultPath(String defaultPath) {
		this.defaultPath = defaultPath;
	}

	/**
	 * 
	 */
	@Override
	public JComponent createCenterComponent() {
		
		return null;
	}
	
	/**
	 * 
	 */
	@Override
	public boolean isFillCenterHorizontal() {		
		return false;
	}
	
}
