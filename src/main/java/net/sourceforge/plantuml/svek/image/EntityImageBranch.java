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
package net.sourceforge.plantuml.svek.image;

import net.sourceforge.plantuml.abel.Entity;
import net.sourceforge.plantuml.klimt.UGroup;
import net.sourceforge.plantuml.klimt.UGroupType;
import net.sourceforge.plantuml.klimt.UStroke;
import net.sourceforge.plantuml.klimt.color.HColor;
import net.sourceforge.plantuml.klimt.drawing.UGraphic;
import net.sourceforge.plantuml.klimt.font.StringBounder;
import net.sourceforge.plantuml.klimt.geom.XDimension2D;
import net.sourceforge.plantuml.klimt.shape.UPolygon;
import net.sourceforge.plantuml.style.PName;
import net.sourceforge.plantuml.style.SName;
import net.sourceforge.plantuml.style.Style;
import net.sourceforge.plantuml.style.StyleSignatureBasic;
import net.sourceforge.plantuml.svek.AbstractEntityImage;
import net.sourceforge.plantuml.svek.ShapeType;

public class EntityImageBranch extends AbstractEntityImage {

	final private static int SIZE = 12;

	public EntityImageBranch(Entity entity) {
		super(entity);
	}

	public StyleSignatureBasic getDefaultStyleDefinition() {
		return StyleSignatureBasic.of(SName.root, SName.element, SName.activityDiagram, SName.activity, SName.diamond);
	}

	public XDimension2D calculateDimension(StringBounder stringBounder) {
		return new XDimension2D(SIZE * 2, SIZE * 2);
	}

	final public void drawU(UGraphic ug) {
		final UPolygon diams = new UPolygon();
		diams.addPoint(SIZE, 0);
		diams.addPoint(SIZE * 2, SIZE);
		diams.addPoint(SIZE, SIZE * 2);
		diams.addPoint(0, SIZE);
		diams.addPoint(SIZE, 0);

		final Style style = getDefaultStyleDefinition().getMergedStyle(getSkinParam().getCurrentStyleBuilder());
		final HColor border = style.value(PName.LineColor).asColor(getSkinParam().getIHtmlColorSet());
		final HColor back = style.value(PName.BackGroundColor).asColor(getSkinParam().getIHtmlColorSet());
		final UStroke stroke = style.getStroke();
		final double shadowing = style.getShadowing();

		diams.setDeltaShadow(shadowing);
		final UGroup group = new UGroup();
		group.put(UGroupType.CLASS, "entity");
		group.put(UGroupType.ID, "entity_" + getEntity().getName());
		group.put(UGroupType.DATA_ENTITY, getEntity().getName());
		group.put(UGroupType.DATA_UID, getEntity().getUid());
		group.put(UGroupType.DATA_QUALIFIED_NAME, getEntity().getQuark().getQualifiedName());
		ug.startGroup(group);
		ug.apply(border).apply(back.bg()).apply(stroke).draw(diams);
		ug.closeGroup();
	}

	public ShapeType getShapeType() {
		return ShapeType.DIAMOND;
	}

}
