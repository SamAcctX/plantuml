/**
 * ditaa - Diagrams Through Ascii Art
 * 
 * Copyright (C) 2004-2011 Efstathios Sideris
 *
 * ditaa is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as 
 * published by the Free Software Foundation, either version 3 of
 * the License, or (at your option) any later version.
 *
 * ditaa is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with ditaa.  If not, see <http://www.gnu.org/licenses/>.
 *   
 */
package org.stathissideris.ascii2image.core;

import java.util.Collection;
import java.util.HashMap;

import org.stathissideris.ascii2image.graphics.CustomShapeDefinition;

public class ConfigurationParser {
	// ::remove folder when __CORE__

	private static final boolean DEBUG = false;

	private static final String INLCUDE_TAG_NAME = "include";
	private static final String SHAPE_TAG_NAME = "shape";
	private static final String SHAPE_GROUP_TAG_NAME = "shapes";

	private String currentDir = "";

	private HashMap<String, CustomShapeDefinition> shapeDefinitions = new HashMap<String, CustomShapeDefinition>();

	public Collection<CustomShapeDefinition> getShapeDefinitions() {
		return shapeDefinitions.values();
	}

	public HashMap<String, CustomShapeDefinition> getShapeDefinitionsHash() {
		return shapeDefinitions;
	}

}

