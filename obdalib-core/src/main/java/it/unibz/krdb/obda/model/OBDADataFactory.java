package it.unibz.krdb.obda.model;

/*
 * #%L
 * ontop-obdalib-core
 * %%
 * Copyright (C) 2009 - 2014 Free University of Bozen-Bolzano
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import it.unibz.krdb.obda.model.Predicate.COL_TYPE;
import it.unibz.krdb.obda.utils.JdbcTypeMapper;

import java.io.Serializable;
import java.net.URI;
import java.util.Collection;
import java.util.List;

public interface OBDADataFactory extends Serializable {

	public OBDAModel getOBDAModel();
	
	public DatatypeFactory getDatatypeFactory();

	public CQIE getCQIE(Function head, Function... body);
	
	public CQIE getCQIE(Function head, List<Function> body);
	
	public CQIE getFreshCQIECopy(CQIE rule);	
	

	public OBDADataSource getDataSource(URI id);

	public DatalogProgram getDatalogProgram();
	
	public DatalogProgram getDatalogProgram(OBDAQueryModifiers modifiers);

	public DatalogProgram getDatalogProgram(Collection<CQIE> rules);

	public DatalogProgram getDatalogProgram(OBDAQueryModifiers modifiers, Collection<CQIE> rules);


	public Function getTripleAtom(Term subject, Term predicate, Term object);

	/**
	 * Construct a {@link Predicate} object.
	 *
	 * @param uri
	 *            the name of the predicate (defined as a URI).
	 * @param arity
	 *            the number of elements inside the predicate.
	 * @return a predicate object.
	 */
	@Deprecated
	public Predicate getPredicate(String uri, int arity);

	public Predicate getPredicate(String uri, COL_TYPE[] types);

	public Predicate getObjectPropertyPredicate(String name);

	public Predicate getDataPropertyPredicate(String name, COL_TYPE type);

	/**
	 * with default type COL_TYPE.LITERAL
	 * @param name
	 * @return
	 */
	
	public Predicate getDataPropertyPredicate(String name);
	
	public Predicate getClassPredicate(String name);


	

	public JdbcTypeMapper getJdbcTypeMapper();

	
	


	/*
	 * Built-in function predicates
	 */

	public Function getUriTemplate(Term...terms);

	public Function getUriTemplate(List<Term> terms);
	
	public Function getUriTemplateForDatatype(String type);
	

	public Function getBNodeTemplate(List<Term> terms);

	public Function getBNodeTemplate(Term... terms);
	
	/**
	 * Construct a {@link Function} object. A function expression consists of
	 * functional symbol (or functor) and one or more arguments.
	 * 
	 * @param functor
	 *            the function symbol name.
	 * @param arguments
	 *            a list of arguments.
	 * @return the function object.
	 */
	public Function getFunction(Predicate functor, Term... terms);

	public Function getFunction(Predicate functor, List<Term> terms);
	/*
	 * Boolean function terms
	 */

	public Function getFunctionEQ(Term firstTerm, Term secondTerm);

	public Function getFunctionGTE(Term firstTerm, Term secondTerm);

	public Function getFunctionGT(Term firstTerm, Term secondTerm);

	public Function getFunctionLTE(Term firstTerm, Term secondTerm);

	public Function getFunctionLT(Term firstTerm, Term secondTerm);

	public Function getFunctionNEQ(Term firstTerm, Term secondTerm);

	public Function getFunctionNOT(Term term);

	public Function getFunctionAND(Term term1, Term term2);

	public Function getFunctionOR(Term term1, Term term2);

	public Function getFunctionIsTrue(Term term);
	
	public Function getFunctionIsNull(Term term);

	public Function getFunctionIsNotNull(Term term);

	public Function getLANGMATCHESFunction(Term term1, Term term2);
	
	/*GeoSPARQL geometry topology functions*/
	public Function getFunctionOverlaps(Term term1, Term term2);
	
	public Function getFunctionSpatialEquals(Term term1, Term term2);
	
	public Function getFunctionSpatialIntersects(Term term1, Term term2);
	public Function getFunctionSpatialDisjoint(Term term1, Term term2);
	public Function getFunctionSpatialTouches(Term term1, Term term2);
	public Function getFunctionSpatialCrosses(Term term1, Term term2);
	public Function getFunctionSpatialWithin(Term term1, Term term2);
	public Function getFunctionSpatialContains(Term term1, Term term2);
	public Function getFunctionEHEquals(Term term1, Term term2);
	public Function getFunctionEHDisjoint(Term term1, Term term2);
	public Function getFunctionEHOverlap(Term term1, Term term2);
	public Function getFunctionEHCovers(Term term1, Term term2);
	public Function getFunctionEHCoveredBy(Term term1, Term term2);
	public Function getFunctionEHInside(Term term1, Term term2);
	public Function getFunctionEHContains(Term term1, Term term2);

	public Function getFunctionGeomFromWKT(Term term1);
	
	public Function getFunctionLike(Term term1, Term term2);
	
	public Function getFunctionRegex(Term term1, Term term2, Term term3);
	
	public Function getFunctionReplace(Term term1, Term term2, Term term3);
	
	public Function getFunctionSHA1(Term arg);

	public Function getFunctionSHA256(Term arg);

	public Function getFunctionSHA512(Term arg);

	public Function getFunctionMD5(Term arg);
	

	

		/*Non topological query functions */
	//TODO implement them: the arguments of some of them will have to change
	
	public Function getFunctionSpatialDistance(Term term1, Term term2);
	public Function getFunctionSpatialBuffer(Term term1, Term term2);
	public Function getFunctionSpatialConvexHull(Term term1, Term term2);
	public Function getFunctionSpatialIntersection(Term term1, Term term2);
	public Function getFunctionSpatialUnion(Term term1, Term term2);
	public Function getFunctionSpatialDifference(Term term1, Term term2);
	public Function getFunctionSpatialsymDifference(Term term1, Term term2);
	public Function getFunctionSpatialEnvelope(Term term1, Term term2);
	public Function getFunctionSpatialBoundary(Term term1, Term term2);
	public Function getFunctionGetSRID(Term term);


	


	/*
	 * Numerical arithmethic functions
	 */

	public Function getFunctionMinus(Term term1);

	public Function getFunctionAdd(Term term1, Term term2);

	public Function getFunctionSubstract(Term term1, Term term2);

	public Function getFunctionMultiply(Term term1, Term term2);
	
	public Function getFunctionAbs(Term term1);
	
	public Function getFunctionCeil(Term term1);
	
	public Function getFunctionFloor(Term term1);
	
	public Function getFunctionRound(Term term1);
	
	public Function getFunctionRand();
	
	public Function getFunctionUUID();

	public Function getFunctionstrUUID();

	/* Functions on strings */

    public Function getFunctionConcat(Term term1, Term term2);
    
 // added by Nika: 
    
    public Function getFunctionLength(Term term1); 
    
	public Function getFunctionSubstring(Term term1, Term term2, Term term3);

	public Function getFunctionSubstring(Term term1, Term term2);

	public Function getFunctionUpper(Term term1);
	
	public Function getFunctionLower(Term term1);
	
	public Function getFunctionStrBefore(Term term1, Term term2);
	
	public Function getFunctionStrAfter(Term term1, Term term2);
	
	public Function getFunctionStrStarts(Term term1, Term term2);
	
	public Function getFunctionStrEnds(Term term1, Term term2);
	
	public Function getFunctionContains(Term term1, Term term2);
	
	public Function getFunctionEncodeForUri(Term term);
	


	/*
	 * Casting values cast(source-value AS destination-type)
	 */
	public Function getFunctionCast(Term term1, Term term2);
	
	/*
	 * JDBC objects
	 */

	public OBDADataSource getJDBCDataSource(String jdbcurl, String username,
			String password, String driverclass);

	public OBDADataSource getJDBCDataSource(String sourceuri, String jdbcurl,
			String username, String password, String driverclass);

	/**
	 * Construct a {@link URIConstant} object. This type of term is written as a
	 * usual URI construction following the generic URI syntax specification
	 * (RFC 3986).
	 * <p>
	 * <code>
	 * scheme://host:port/path#fragment
	 * </code>
	 * <p>
	 * Examples:
	 * <p>
	 * <code>
	 * http://example.org/some/paths <br />
	 * http://example.org/some/paths/to/resource#frag01 <br />
	 * ftp://example.org/resource.txt <br />
	 * </code>
	 * <p>
	 * are all well-formed URI strings.
	 * 
	 * @param uri
	 *            the URI.
	 * @return a URI constant.
	 */
	public URIConstant getConstantURI(String uri);
	
	public BNode getConstantBNode(String name);

	public ValueConstant getBooleanConstant(boolean value);
	
	/**
	 * Construct a {@link ValueConstant} object.
	 * 
	 * @param value
	 *            the value of the constant.
	 * @return the value constant.
	 */
	public ValueConstant getConstantLiteral(String value);

	/**
	 * Construct a {@link ValueConstant} object with a type definition.
	 * <p>
	 * Example:
	 * <p>
	 * <code>
	 * "Person"^^xsd:String <br />
	 * 22^^xsd:Integer
	 * </code>
	 * 
	 * @param value
	 *            the value of the constant.
	 * @param type
	 *            the type of the constant.
	 * @return the value constant.
	 */
	public ValueConstant getConstantLiteral(String value, Predicate.COL_TYPE type);


	/**
	 * Construct a {@link ValueConstant} object with a language tag.
	 * <p>
	 * Example:
	 * <p>
	 * <code>
	 * "This is American English"@en-US <br />
	 * </code>
	 * 
	 * @param value
	 *            the value of the constant.
	 * @param language
	 *            the language tag for the constant.
	 * @return the value constant.
	 */
	public ValueConstant getConstantLiteral(String value, String language);

	public Function getTypedTerm(Term value, String language);
	public Function getTypedTerm(Term value, Term language);
	public Function getTypedTerm(Term value, Predicate.COL_TYPE type);
	
	/**
	 * Construct a {@link ValueConstant} object with a system-assigned name
	 * that is automatically generated.
	 * 
	 * @return the value constant.
	 */
	public ValueConstant getConstantFreshLiteral();
	
	/**
	 * Construct a {@link Variable} object. The variable name is started by a
	 * dollar sign ('$') or a question mark sign ('?'), e.g.:
	 * <p>
	 * <code>
	 * pred($x) <br />
	 * func(?x, ?y)
	 * </code>
	 * 
	 * @param name
	 *            the name of the variable.
	 * @return the variable object.
	 */
	public Variable getVariable(String name);
	
	
	/* OBDA mapping axioms */
	
	public OBDAMappingAxiom getRDBMSMappingAxiom(String id, OBDASQLQuery sourceQuery, List<Function> targetQuery);

	public OBDAMappingAxiom getRDBMSMappingAxiom(OBDASQLQuery sourceQuery, List<Function> targetQuery);

	public OBDASQLQuery getSQLQuery(String query);

	/* SPARQL meta-predicates */
	
	public Function getSPARQLJoin(Function t1, Function t2);

	public Function getSPARQLLeftJoin(Function t1, Function t2);

	/* time functions */
	
	Predicate getDataTypePredicateGeosparql();
	public Function getFunctionNow();

	public Function getFunctionYear(Term arg);
	
	public Function getFunctionDay(Term arg);
	
	public Function getFunctionMinutes(Term arg);
	
	public Function getFunctionSeconds(Term arg);
	
	public Function getFunctionHours(Term arg);
	
	public Function getFunctionTZ(Term arg);

	public Function getFunctionMonth(Term arg);
}
