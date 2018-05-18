/**
 * 
 */
package com.roche.infinity.install4j.wrapper.filechooser;

import javax.swing.JComponent;
import com.install4j.api.formcomponents.AbstractFormComponent;
import com.roche.infinity.screen.component.filechooser.RocheFileChooser;

/**
 * @author grebonfe
 * @date May 2018
 * Define the file chooser wrapper
 */
public class RocheFileChooserWrapper extends AbstractFormComponent{

	protected RocheFileChooser rocheFileChooser;
	
	/**
	 * @return the rocheFileChooser
	 */
	public RocheFileChooser getRocheFileChooser() {
		return rocheFileChooser;
	}

	@Override
	public JComponent createCenterComponent() {
		return rocheFileChooser;
	}

	@Override
	public boolean isFillCenterHorizontal() {		
		return false;
	}	
}
