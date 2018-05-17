/**
 * 
 */
package com.roche.infinity.install4j.wrapper.filechooser;

import javax.swing.JComponent;
import com.install4j.api.formcomponents.AbstractFormComponent;
import com.roche.infinity.screen.component.filechooser.RocheFileChooser;

/**
 * @author grebonfe
 *
 */
public class RocheFileChooserWrapper extends AbstractFormComponent{

	@Override
	public JComponent createCenterComponent() {
		return new RocheFileChooser();
	}

	@Override
	public boolean isFillCenterHorizontal() {
		// TODO Auto-generated method stub
		return false;
	}

	
}
