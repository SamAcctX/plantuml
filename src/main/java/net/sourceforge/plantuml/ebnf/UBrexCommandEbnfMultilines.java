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
package net.sourceforge.plantuml.ebnf;

import com.plantuml.ubrex.UnicodeBracketedExpression;
import com.plantuml.ubrex.builder.UBrexConcat;
import com.plantuml.ubrex.builder.UBrexLeaf;
import com.plantuml.ubrex.builder.UBrexNamed;

import net.sourceforge.plantuml.Lazy;
import net.sourceforge.plantuml.command.CommandExecutionResult;
import net.sourceforge.plantuml.command.MultilinesStrategy;
import net.sourceforge.plantuml.command.ParserPass;
import net.sourceforge.plantuml.command.Trim;
import net.sourceforge.plantuml.command.UBrexCommandMultilines2;
import net.sourceforge.plantuml.klimt.color.NoSuchColorException;
import net.sourceforge.plantuml.utils.BlocLines;

public class UBrexCommandEbnfMultilines extends UBrexCommandMultilines2<PSystemEbnf> {

	private final static Lazy<UnicodeBracketedExpression> END = new Lazy<>(() -> new UBrexLeaf("〇+〘 〄>; 〙"));

	public UBrexCommandEbnfMultilines() {
		super(getRegexConcat(), MultilinesStrategy.KEEP_STARTING_QUOTE, Trim.BOTH, END);
	}

	static UnicodeBracketedExpression getRegexConcat() {

		return new UBrexNamed("LINE", //
				UBrexConcat.build( //
						new UBrexLeaf("「〴an_」"), //
						new UBrexLeaf("〇*「〴an_-」"), //
						UBrexLeaf.spaceZeroOrMore(), //
						new UBrexLeaf("="), //
						new UBrexLeaf("〇*〴.") //
				));

	}

	@Override
	protected CommandExecutionResult executeNow(PSystemEbnf diagram, BlocLines lines, ParserPass currentPass)
			throws NoSuchColorException {
		return diagram.addBlocLines(lines, null, null);
	}

}
