/**
 * 
 */
package com.roche.infinity.install4j.wrapper.filechooser;

import javax.swing.JComponent;
import com.install4j.api.formcomponents.AbstractFormComponent;
import com.roche.infinity.screen.component.button.RocheButton;
import com.roche.infinity.screen.component.filechooser.RocheFileChooser;

/**
 * @author grebonfe
 *
 */
public class RocheFileChooserWrapper extends AbstractFormComponent{

	protected RocheFileChooser rocheFileChooser;
	
	@Override
	public JComponent createCenterComponent() {
		rocheFileChooser = new RocheFileChooser();
		
		return rocheFileChooser;
	}

	@Override
	public boolean isFillCenterHorizontal() {
		
		return false;
	}

	
}
