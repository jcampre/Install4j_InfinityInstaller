/**
 * 
 */
package com.roche.infinity.install4j.component.filechooser;

import javax.swing.JComponent;

import com.install4j.api.beans.ExternalFile;
import com.roche.infinity.install4j.wrapper.filechooser.RocheFileChooserWrapper;
import com.roche.infinity.screen.component.filechooser.RocheFileChooser;

/**
 * @author grebonfe
 *
 */
public class RocheFileChooser4j extends RocheFileChooserWrapper{
	ExternalFile defaultPath;
	
	/**
	 * @return the defaultPath
	 */
	public ExternalFile getDefaultPath() {
		return defaultPath;
	}

	/**
	 * @param defaultPath the defaultPath to set
	 */
	public void setDefaultPath(ExternalFile defaultPath) {
		this.defaultPath = defaultPath;
	}

	/**
	 * 
	 */
	@Override
	public JComponent createCenterComponent() {
		rocheFileChooser = new RocheFileChooser(defaultPath);
		
		return rocheFileChooser;
	}
	
	/**
	 * 
	 */
	@Override
	public boolean isFillCenterHorizontal() {		
		return false;
	}
	
}
