/* ========================================================================
 * PlantUML : a free UML diagram generator
 * ========================================================================
 *
 * (C) Copyright 2009-2024, Arnaud Roques
 *
 * Project Info:  https://plantuml.com
 * 
 * If you like this project or if you find it useful, you can support us at:
 * 
 * https://plantuml.com/patreon (only 1$ per month!)
 * https://plantuml.com/paypal
 * 
 * This file is part of PlantUML.
 *
 * PlantUML is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * PlantUML distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public
 * License for more details.
 *
 * You should have received a copy of the GNU General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301,
 * USA.
 *
 *
 * Original Author:  Arnaud Roques
 * 
 *
 */
package net.sourceforge.plantuml.klimt.creole;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.sourceforge.plantuml.klimt.geom.HorizontalAlignment;

public class Sheet implements Iterable<Stripe> {

	private final List<Stripe> stripes = new ArrayList<>();
	private final HorizontalAlignment horizontalAlignment;

	public Sheet(HorizontalAlignment horizontalAlignment) {
		this.horizontalAlignment = horizontalAlignment;
	}

	@Override
	public String toString() {
		return stripes.toString();
	}

	public void add(Stripe stripe) {
		stripes.add(stripe);
	}

	public void add(List<Stripe> stripes) {
		for (Stripe s : stripes)
			this.add(s);
	}

	public Iterator<Stripe> iterator() {
		return stripes.iterator();
	}

	public Stripe getLastStripe() {
		final int size = stripes.size();
		if (size == 0) {
			return null;
		}
		return stripes.get(size - 1);
	}

	public final HorizontalAlignment getHorizontalAlignment() {
		return horizontalAlignment;
	}
}
