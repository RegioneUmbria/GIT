
<%response.setHeader("Cache-Control","no-cache");
response.setHeader("Pragma","no-cache");
response.setDateHeader ("Expires", 0);


String cn=request.getParameter("cn")!=null&&!request.getParameter("cn").trim().equals("")?request.getParameter("cn"):null;
String fgl=request.getParameter("fgl")!=null&&!request.getParameter("fgl").trim().equals("")?request.getParameter("fgl"):null;
String par=request.getParameter("par")!=null&&!request.getParameter("par").trim().equals("")?request.getParameter("par"):null;
String sub=request.getParameter("sub")!=null&&!request.getParameter("sub").trim().equals("")?request.getParameter("sub"):null;
String pkana=request.getParameter("pkana")!=null&&!request.getParameter("pkana").trim().equals("")?request.getParameter("pkana"):null;
String pkciv=request.getParameter("pkciv")!=null&&!request.getParameter("pkciv").trim().equals("")?request.getParameter("pkciv"):null;

Context cont= new InitialContext();

DataSource theDataSource = null;
theDataSource =(DataSource)cont.lookup("java:/jdbc/Diogene_DS" + "_" + cn);


%>
<%!
public String scriviLayerCat(Connection Conn, String Descrizione, String Tabella, String ShapeType, String SQLDescr, String IdCat, String PLDecodeDescr, String PLEncode, String IdField, long Storicizzato)
{
  Statement ST=null;
  ResultSet RS=null;

  String RetVal="";
  RetVal+="  <layer>";
  RetVal+="    <name>" + Descrizione + "</name>";
  RetVal+="    <table>" + Tabella + "</table>";
  RetVal+="    <shape_field>SHAPE</shape_field>";
  if(Storicizzato==1)
    RetVal+="    <where>ID_CAT="+ IdCat +" AND DATA_FINE_VAL=TO_DATE('99991231000000', 'YYYYMMDDHH24MISS')</where>";
  else
    RetVal+="    <where>ID_CAT="+ IdCat +"</where>";
  
    if (Descrizione.equalsIgnoreCase("STA04: ZONE CENSUARIE")) {
   	  RetVal+="    <text_color>2</text_color>";
   	  RetVal+="    <text_height>10</text_height>";
   	  RetVal+="    <text_visible>Y</text_visible>";
   	  RetVal+="    <InfoURL>../infoPart.jsp</InfoURL>";
    } else if (Descrizione.equalsIgnoreCase("STA03: VALORE MEDIO RENDITA PER VANO")) {
  	  RetVal+="    <text_label>VM_RENDITA_VANO</text_label>";
  	  RetVal+="    <text_color>2</text_color>";
  	  RetVal+="    <text_height>10</text_height>";
  	  RetVal+="    <text_visible>Y</text_visible>";
    } else if (Descrizione.equalsIgnoreCase("STA01: UNITA ABITATIVE CON DOCFA") ) { 
  	  RetVal+="    <text_label>OCCORRENZE</text_label>";
  	  RetVal+="    <text_color>2</text_color>";
  	  RetVal+="    <text_height>10</text_height>";
  	  RetVal+="    <text_visible>Y</text_visible>";    	
  	  RetVal+="    <InfoURL>../infoPart.jsp</InfoURL>";
    } else if (Descrizione.equalsIgnoreCase("STA02: UNITA ABITATIVE CON DOCFA SOTTOCLASSATE") ) { 
    	  RetVal+="    <text_label>OCCORRENZE</text_label>";
      	  RetVal+="    <text_color>2</text_color>";
      	  RetVal+="    <text_height>10</text_height>";
      	  RetVal+="    <text_visible>Y</text_visible>";    	
      	  RetVal+="    <InfoURL>../infoPart.jsp</InfoURL>";
    } else if (Descrizione.equalsIgnoreCase("PREGEO PRESENTATI SU FOGLIO") ) { 
	  	  RetVal+="    <text_label>s.OCCORRENZE</text_label>";
  	  	  RetVal+="    <text_color>7</text_color>";
  	  	  RetVal+="    <text_height>10</text_height>";
  	      RetVal+="    <text_visible>Y</text_visible>";    	
  	      RetVal+="    <InfoURL>../infoPart.jsp</InfoURL>";
    }	else {
	  RetVal+="    <text_label>"+ PLDecodeDescr +"("+ PLEncode +"(CODICE))</text_label>";
	  RetVal+="    <text_color>2</text_color>";
	  RetVal+="    <text_height>10</text_height>";
	  RetVal+="    <text_visible>N</text_visible>";
  	}
  RetVal+="    <text_scale_min>1.5</text_scale_min>";
  RetVal+="    <shape_type>" + ShapeType + "</shape_type>";
  RetVal+="    <ident>" + IdField + "</ident>";
  RetVal+="    <on>N</on>";
  RetVal+="    <always_listed>Y</always_listed>";
  RetVal+="    <apply_spatial_where>Y</apply_spatial_where>";
  RetVal+="    <scaled_displist>Y</scaled_displist>";
  if(ShapeType.equals("0"))
  {
    RetVal+="    <line_color>7</line_color>"; 
    RetVal+="    <poly_fill_color>2</poly_fill_color>";
    RetVal+="    <poly_fill_style>1</poly_fill_style>";
  }
  else
    RetVal+="    <line_color>2</line_color>";
  RetVal+="    <default_theme_name>"+ Descrizione +"</default_theme_name>";
  RetVal+="    <theme>";
  RetVal+="      <name>"+ Descrizione +"</name>";
  RetVal+="      <description>"+ Descrizione +"</description>";
  RetVal+="      <expression_type>N</expression_type>";
  RetVal+="      <expression>"+ PLEncode +"(CODICE)</expression>";
  
  try
  {
    ST=Conn.createStatement();
    RS=ST.executeQuery(SQLDescr);
    while(RS.next())
    {
      RetVal+="      <theme_entry>";
      RetVal+="        <on>Y</on>";
      RetVal+="        <description>"+ RS.getString("DESCRIZIONE") +"</description>";
      RetVal+="        <unique_value>"+ RS.getString("CODICE") +"</unique_value>";
      if(ShapeType.equals("0"))
      {	
        RetVal+="        <line_color>"+ RS.getString("COLORELINEA") +"</line_color>";
        RetVal+="        <poly_fill_color>"+ RS.getString("COLORE") +"</poly_fill_color>";
        RetVal+="        <poly_fill_style>"+ RS.getString("RIEMPIMENTO") +"</poly_fill_style>";
		
      }
      else
        RetVal+="        <line_color>"+ RS.getString("COLORE") +"</line_color>";

      RetVal+="      </theme_entry>";
    }
  }
  catch(SQLException e)
  {
    e.printStackTrace();
  }
  finally
  {
	  try {
		  if (RS!=null)
			  RS.close();
		  if (ST!=null)
			  ST.close();
	  } catch (SQLException e) { 
	  }
  }
  RetVal+="    </theme>";
  RetVal+="  </layer>";
  return RetVal;
}
%>


<?xml version="1.0" encoding="UTF-8"?>
<!-- Created by DbMAP ASJ Viewer/Author by ABACO s.r.l. (http://www.abacogroup.com) -->

<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.naming.Context"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="java.sql.SQLException"%>
<%@page import="org.apache.log4j.Logger"%>
<DbMAP_asj_Project>

	<ServerURL><%="http://"+request.getServerName()+":"+ request.getServerPort()%>/DbMAP_ASJ_servlet/<%=cn%>/DbMAPservlet?function=</ServerURL>
	<InfoURL><%="http://"+request.getServerName()+":"+ request.getServerPort()%>/DbMAP_ASJ_servlet/<%=cn%>/DbMAPinfo</InfoURL>


<Palette>
		<BackgroundColor>
			<rgb>0 0 0</rgb>
		</BackgroundColor>
		<HiliteColor>
			<rgb>255 255 0</rgb>
		</HiliteColor>
		<HiliteColor2>
			<rgb>150 77 27</rgb>
		</HiliteColor2>
    <Color>
      <index>1</index>
      <rgb>255 0 0</rgb>
    </Color>
    <Color>
      <index>2</index>
      <rgb>255 255 0</rgb>
    </Color>
    <Color>
      <index>3</index>
      <rgb>0 255 0</rgb>
    </Color>
    <Color>
      <index>4</index>
      <rgb>0 255 255</rgb>
    </Color>
    <Color>
      <index>5</index>
      <rgb>0 0 255</rgb>
    </Color>
    <Color>
      <index>6</index>
      <rgb>255 0 255</rgb>
    </Color>
    <Color>
      <index>7</index>
      <rgb>0 0 0</rgb>
    </Color>
    <Color>
      <index>8</index>
      <rgb>255 255 255</rgb>
    </Color>
    <Color>
      <index>9</index>
      <rgb>192 192 192</rgb>
    </Color>
    <Color>
      <index>10</index>
      <rgb>128 128 128</rgb>
    </Color>
    <Color>
      <index>11</index>
      <rgb>0 128 0</rgb>
    </Color>
    <Color>
      <index>12</index>
      <rgb>255 192 255</rgb>
    </Color>
    <Color>
      <index>13</index>
      <rgb>200 185 150</rgb>
    </Color>
    <Color>
      <index>14</index>
      <rgb>247 108 82</rgb>
    </Color>
    <Color>
      <index>15</index>
      <rgb>244 162 124</rgb>
    </Color>
  </Palette>

	<default_view_computed>
<%if(pkana != null){%>
	<table>DUAL</table> 
	  <shape_field>INGOMBRO_ANAGRAFE(<%=cn==null?"NULL":"'"+cn+"'"%>,'<%=pkana%>')</shape_field> 
	  <where /> 
	   <zoom_factor>10</zoom_factor>
<%}else if(pkciv != null){%>
	<table>DUAL</table> 
	  <shape_field>INGOMBRO_CIVICI(<%=cn==null?"NULL":"'"+cn+"'"%>,'<%=pkciv%>',NULL)</shape_field> 
	  <where /> 
	   <zoom_factor>8</zoom_factor>
<%}else if(fgl != null){%>
	<table>DUAL</table> 
	  <shape_field>INGOMBRO_PARTICELLA(<%=cn==null?"NULL":"'"+cn+"'"%>,<%=fgl==null?"NULL":fgl%>,<%=par==null?"NULL":"'"+par+"'"%>,<%=sub==null?"NULL":"'"+sub+"'"%>,NULL)</shape_field> 
	  <where /> 
	 <!--  <zoom_factor_max>2.2</zoom_factor_max> -->
<%}else{ %>
		<table>SITICOML S</table>
		<shape_field>SHAPE</shape_field>
		<where> LPAD(S.ISTATP,3,'0') || LPAD(S.ISTATC,3,0)IN (SELECT COD_ISTAT FROM SIT_ENTE)</where>
 <%}%> 
	
  </default_view_computed>
  
	<Layer>
		<name>Foto</name>
		<table>SITIFOTW</table>
		<shape_field>SHAPE</shape_field>
		<where>*</where>
		<shape_type>4</shape_type>
		<always_listed>Y</always_listed>
		<scaled_displist>Y</scaled_displist>
		<text_label>FILENAME</text_label>
		<text_visible>N</text_visible>
		<text_font>SansSerif</text_font>
		<poly_fill_color>80</poly_fill_color>
		<poly_fill_style>1</poly_fill_style>
		<poly_fill_xor>N</poly_fill_xor>
		<union_type>ECW</union_type>
	</Layer>

	<Layer>
		<name>Fogli</name>
		<InfoURL>../infoFogli.jsp</InfoURL>
		<table>SITIFGLC B, SITICOMU C</table>
		<shape_field>B.SHAPE</shape_field>
		<where>B.COD_NAZIONALE = C.COD_NAZIONALE AND C.CODI_FISC_LUNA in (select codent from sit_ente)</where>
		<shape_type>0</shape_type>
		<always_listed>Y</always_listed>
		<scaled_displist>Y</scaled_displist>
		<line_color>160</line_color>
		<line_thick>2</line_thick>
		<text_label>'Foglio ' || B.FOGLIO || ' allegato ' || B.ALLEGATO</text_label>
		<text_color>160</text_color>
		<text_height>10</text_height>
		<text_visible>N</text_visible>
		<text_font>SansSerif</text_font>
	</Layer>

	<Layer>
		<name>Particelle</name>
		<InfoURL>../infoPart.jsp</InfoURL>
		<table>CAT_PARTICELLE_GAUSS</table>
		<shape_field>GEOMETRY</shape_field>
		<where>COMUNE in (select COD_NAZIONALE from sit_ente E , SITICOMU C  WHERE E.CODENT = C.CODI_FISC_LUNA ) and layer='PARTICELLE'</where>
		<shape_type>0</shape_type>
		<ident>PK_PARTICELLE</ident>
		<scale_min>0.42237384377543336</scale_min>
		<always_listed>Y</always_listed>
		<line_color>7</line_color>
		<line_thick>1</line_thick>
		<text_label>'Foglio ' || FOGLIO || ' part. ' || PARTICELLA || ' alleg. ' || ALLEGATO</text_label>
		<text_color>1</text_color>
		<text_height>10</text_height>
		<text_visible>N</text_visible>
		<text_font>SansSerif</text_font>
		<poly_fill_color>11</poly_fill_color>
 		<poly_fill_style>8</poly_fill_style>
		<poly_fill_xor>N</poly_fill_xor>
		<predefined_search>
			<name>FoglioParticella</name>
			<description>Ricerca foglio / particella</description>
			<whereTemplate>FOGLIO ='_x_' and PARTICELLA = '_y_'</whereTemplate>
			<predefined_search_param>
				<name>_x_</name>
				<description>Foglio</description>
				<prompt>Immettere Foglio</prompt>
			</predefined_search_param>
			<predefined_search_param>
				<name>_y_</name>
				<description>Particella</description>
				<prompt>Immettere Particella</prompt>
			</predefined_search_param>
		</predefined_search>
	</Layer>



  	
	<Layer>
		<name>Fabbricati</name>
		<InfoURL>../infoPart.jsp</InfoURL>
		<table>CAT_PARTICELLE_GAUSS</table>
		<shape_field>GEOMETRY</shape_field>
		<where>COMUNE in (select COD_NAZIONALE from sit_ente E , SITICOMU C  WHERE E.CODENT = C.CODI_FISC_LUNA ) and layer='FABBRICATI'</where>
		<shape_type>0</shape_type>
		<ident>PK_PARTICELLE</ident>
		<scale_min>0.42237384377543336</scale_min>
		<always_listed>Y</always_listed>
		<line_color>7</line_color>
		<line_thick>1</line_thick>
		<text_label>'Foglio ' || FOGLIO || ' part. ' || PARTICELLA || ' alleg. ' || ALLEGATO</text_label>
		<text_color>1</text_color>
		<text_height>10</text_height>
		<text_visible>N</text_visible>
		<text_font>SansSerif</text_font>
		<poly_fill_color>41</poly_fill_color>
		<poly_fill_style>1</poly_fill_style>
		<poly_fill_xor>N</poly_fill_xor>
	</Layer>

	<Layer>
		<name>Civici</name>
		<InfoURL>../infoPart.jsp</InfoURL>
		<table>(SELECT SITICIVI.COD_NAZIONALE, siticomu.CODI_FISC_LUNA , SITICIVI.DATA_FINE_VAL, PKID_CIVI, SHAPE,SITIDSTR.PREFISSO || ' ' || SITIDSTR.NOME VIA, siticivi.civico  FROM SITICIVI, SITIDSTR, SITICOMU WHERE  sitidstr.pkid_stra = SITICIVI.PKID_STRA AND SITICIVI.COD_NAZIONALE = SITICOMU.COD_NAZIONALE)</table>
		<shape_field>SHAPE</shape_field>
		<where>CODI_FISC_LUNA in (select codent from sit_ente) and DATA_FINE_VAL =to_date('31/12/9999','dd/mm/yyyy')</where>
		<shape_type>1</shape_type>
		<ident>PKID_CIVI</ident>
		<scale_min>1.5</scale_min>
		<always_listed>Y</always_listed>
		<line_color>151</line_color>
		<line_thick>1</line_thick>
		<text_label>via ||' ,' ||CIVICO</text_label>
		<text_color>2</text_color>
		<text_height>12</text_height>
		<text_flags>0</text_flags>
		<text_font>SansSerif</text_font>
		<text_scale_min>1.5</text_scale_min>
		<point_style>-1</point_style>
		<point_image>gifs/red_point.gif</point_image>
		<point_image_thumbnail></point_image_thumbnail>
		<poly_fill_color>133</poly_fill_color>
		<poly_fill_style>1</poly_fill_style>
		<poly_fill_xor>N</poly_fill_xor>
	</Layer>
	
	<% if (false) {%>
	<Layer>
		<name>CiviciAbitati</name>
		<InfoURL>../infoPart.jsp</InfoURL>
		<table>(SELECT SITICIVI.COD_NAZIONALE, siticomu.CODI_FISC_LUNA , SITICIVI.DATA_FINE_VAL, PKID_CIVI, SHAPE, SITIDSTR.PREFISSO || ' ' || SITIDSTR.NOME VIA, siticivi.civico  FROM SITICIVI, SITIDSTR, SITICOMU WHERE  sitidstr.pkid_stra = SITICIVI.PKID_STRA AND SITICIVI.COD_NAZIONALE = SITICOMU.COD_NAZIONALE)</table>
		<shape_field>SHAPE</shape_field>
		<where>CODI_FISC_LUNA in (select codent from sit_ente) and DATA_FINE_VAL =to_date('31/12/9999','dd/mm/yyyy') AND EXISTS(SELECT 1 FROM PERSONA_CIVICI_SHAPE_V WHERE PERSONA_CIVICI_SHAPE_V.PK_SITICIVI = PKID_CIVI)</where>
		<shape_type>1</shape_type>
		<ident>PKID_CIVI</ident>
		<scale_min>1.5</scale_min>
		<always_listed>Y</always_listed>
		<line_color>151</line_color>
		<line_thick>1</line_thick>
		<point_style>-1</point_style>
		<point_image>gifs/spunta.gif</point_image>
		<point_image_thumbnail></point_image_thumbnail>
		<poly_fill_color>133</poly_fill_color>
		<poly_fill_style>1</poly_fill_style>
		<poly_fill_xor>N</poly_fill_xor>
	</Layer>
	<% } %>
	
	<!-- solo per Milano (F205) -->
	<%if (cn.equalsIgnoreCase("F205")) {%>
		<Layer>
			<name>Civici-Cosap</name>
			<InfoURL>../infoPart.jsp</InfoURL>
			<table>
			(SELECT PK_SEQU_CIVICO pkid_civi, SITICIVI.shape, SIT_V_COSAP.VS_COD_CNT cod_conribuente
			   FROM VISTA_CIVICI , sit_v_cosap, SITICIVI
			  WHERE SIT_V_COSAP.AC_COD_VIA = VISTA_CIVICI.CODICE_VIA
			  AND TO_CHAR(SIT_V_COSAP.AC_NUM_CIV) =  VISTA_CIVICI.DESCRIZIONE_CIVICO_NO_BARRA 
			  AND VISTA_CIVICI.PK_SEQU_CIVICO = SITICIVI.PKID_CIVI
			)
			</table>
			<shape_field>SHAPE</shape_field>
			<where></where>
			<shape_type>1</shape_type>
			<ident>cod_conribuente</ident>
			<scale_min>0.42237384377543336</scale_min>
			<scale_min>1.5</scale_min>
			<always_listed>Y</always_listed>
			<line_color>151</line_color>
			<line_thick>1</line_thick>
			<point_style>-1</point_style>
			<point_image>gifs/segnaposto.gif</point_image>
			<point_image_thumbnail></point_image_thumbnail>
			<poly_fill_color>133</poly_fill_color>
			<poly_fill_style>1</poly_fill_style>
			<poly_fill_xor>N</poly_fill_xor>
		</Layer>
	<% } %>

<%if(fgl != null)
{
	
	
	String wherepartcor = "COMUNE='"+cn+"' AND LPAD(TRIM(FOGLIO),6,'0')=LPAD(TRIM('"+fgl+"'),6,'0') ";
	if(par != null) 
		wherepartcor += " and LPAD(TRIM(PARTICELLA),5,'0')=LPAD(TRIM('"+par+"'),5,'0') ";
	wherepartcor += " and layer='PARTICELLE'";
			%>
				<Layer>
				  <name>Particella Corrente</name> 
				  <table>CAT_PARTICELLE_GAUSS</table>
				  <shape_field>GEOMETRY</shape_field>
					<where><%=wherepartcor%></where>
			
					<shape_type>0</shape_type>
					<ident>PK_PARTICELLE</ident>
					<scale_min>0.42237384377543336</scale_min>
					<always_listed>Y</always_listed>
					<line_color>1</line_color>
					<line_thick>1</line_thick>
					<text_label>'Foglio ' || FOGLIO || ' part. ' || PARTICELLA || ' alleg. ' || ALLEGATO</text_label>
					<text_color>2</text_color>
					<text_height>10</text_height>
					<text_visible>Y</text_visible>
					<text_font>SansSerif</text_font>
					<poly_fill_color>1</poly_fill_color>
					<poly_fill_style>8</poly_fill_style>
					<poly_fill_xor>N</poly_fill_xor>
				    
				  </Layer>
	 	  	
<%}%>

<%if(pkciv != null){%>
	<Layer>
		<name>Civico Selezionato</name>
		<InfoURL>../infoPart.jsp</InfoURL>
		<table>(SELECT SITICIVI.COD_NAZIONALE, siticomu.CODI_FISC_LUNA, SITICIVI.DATA_FINE_VAL, PKID_CIVI, SHAPE,SITIDSTR.PREFISSO || ' ' || SITIDSTR.NOME VIA, siticivi.civico  FROM SITICIVI, SITIDSTR, SITICOMU WHERE  sitidstr.pkid_stra = SITICIVI.PKID_STRA AND SITICIVI.COD_NAZIONALE = SITICOMU.COD_NAZIONALE)</table>
		<shape_field>SHAPE</shape_field>
		<where>CODI_FISC_LUNA in (select codent from sit_ente) and DATA_FINE_VAL =to_date('31/12/9999','dd/mm/yyyy') and PKID_CIVI = <%=pkciv %></where>
		<shape_type>1</shape_type>
		<ident>PKID_CIVI</ident>
		<scale_min>1.5</scale_min>
		<always_listed>Y</always_listed>
		<line_color>90</line_color>
		<line_thick>1</line_thick>
		<poly_fill_color>90</poly_fill_color>
		<poly_fill_style>7</poly_fill_style>
		<poly_fill_xor>N</poly_fill_xor>
	</Layer>
<%}%>



<% 

	Connection cnn = theDataSource.getConnection();


  Statement ST=null;
  ResultSet RS=null;
  Statement ST2=null;
  ResultSet RS2=null;

  try
  {
    ST=cnn.createStatement();
    RS=ST.executeQuery("SELECT ID_FIELD, TABELLA, DESCRIZIONE, SQLDESCR, SHAPE_TYPE, SQLTOOLTIPS, PLDECODE_DESCR, PLENCODE, STORICIZZATO,ID_CAT FROM SITICATALOG order by DESCRIZIONE");
    while(RS.next())
    {
        String ShapeType="0";
        if(RS.getString("SHAPE_TYPE").equalsIgnoreCase("LINE"))
          ShapeType="3";
        else if(RS.getString("SHAPE_TYPE").equalsIgnoreCase("POINT"))
          ShapeType="1";

%>
<%=scriviLayerCat(cnn, RS.getString("DESCRIZIONE"), RS.getString("TABELLA"), ShapeType, RS.getString("SQLDESCR"), RS.getString("ID_CAT"), RS.getString("PLDECODE_DESCR"), RS.getString("PLENCODE"), RS.getString("ID_FIELD"), RS.getLong("STORICIZZATO"))%>
<%
	// qui cera del codice ma non riportato (vedi progetto.jsp da siti)
%>

<%
    }

  }
  catch(SQLException e)
  {
	 e.printStackTrace();

  }
  finally
  {
	  try {
		  if (RS!=null)
			  RS.close();
		  if (ST!=null)
			  ST.close();
		  if (RS2!=null)
			  RS2.close();
		  if (ST2!=null)
			  ST2.close();
		  if (cnn!=null)
			  cnn.close();
	  } catch (SQLException e) { 
	  }  
  }
  %>
  
</DbMAP_asj_Project>