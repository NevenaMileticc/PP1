package rs.ac.bg.etf.pp1;

import java_cup.runtime.Symbol;

%%

%{

	// ukljucivanje informacije o poziciji tokena
	private Symbol new_symbol(int type) {
		return new Symbol(type, yyline+1, yycolumn);
	}
	
	// ukljucivanje informacije o poziciji tokena
	private Symbol new_symbol(int type, Object value) {
		return new Symbol(type, yyline+1, yycolumn, value);
	}

%}

%cup
%line
%column

%xstate COMMENT

%eofval{
	return new_symbol(sym.EOF);
%eofval}

%%

" " 	{ }
"\b" 	{ }
"\t" 	{ }
"\r\n" 	{ }
"\f" 	{ }

"program"   { return new_symbol(sym.PROG, yytext()); }
"break"     { return new_symbol(sym.BREAK, yytext());}
"else"      { return new_symbol(sym.ELSE, yytext());}
"const"     { return new_symbol(sym.CONST, yytext());}
"if"        { return new_symbol(sym.IF, yytext());}
"new"       { return new_symbol(sym.NEW, yytext());}
"print" 	{ return new_symbol(sym.PRINT, yytext()); }
"read" 	    { return new_symbol(sym.READ, yytext()); }
"return" 	{ return new_symbol(sym.RETURN, yytext()); }
"void" 		{ return new_symbol(sym.VOID, yytext()); }
"continue"  { return new_symbol(sym.CONTINUE, yytext());}
"set"       { return new_symbol(sym.SET, yytext());}
"union"     { return new_symbol(sym.UNION, yytext());}
"do"        { return new_symbol(sym.DO, yytext());}
"while"     { return new_symbol(sym.WHILE, yytext());}
"map"       { return new_symbol(sym.MAP, yytext());}


'.' 		{ return new_symbol(sym.CHAR_CONST, yytext().charAt(1));}
"true" 		{ return new_symbol(sym.BOOL_CONST, true);}
"false" 	{ return new_symbol(sym.BOOL_CONST, false);}


"+" 		{ return new_symbol(sym.PLUS, yytext()); }
"-" 		{ return new_symbol(sym.MINUS, yytext()); }
"*" 		{ return new_symbol(sym.PUTA, yytext()); }
"/" 		{ return new_symbol(sym.PODELJENO, yytext()); }
"%" 		{ return new_symbol(sym.MODUO, yytext()); }
"=" 		{ return new_symbol(sym.JEDNAKO, yytext()); }
"==" 		{ return new_symbol(sym.JEDNAKO_JEDNAKO, yytext()); }
"!=" 		{ return new_symbol(sym.RAZLICITO, yytext()); }
">" 		{ return new_symbol(sym.VECE, yytext()); }
">=" 		{ return new_symbol(sym.VECE_JEDNAKO, yytext()); }
"<" 		{ return new_symbol(sym.MANJE, yytext()); }
"<=" 		{ return new_symbol(sym.MANJE_JEDNAKO, yytext()); }
"&&" 		{ return new_symbol(sym.AND, yytext()); }
"||" 		{ return new_symbol(sym.ILI, yytext()); }
"++" 		{ return new_symbol(sym.PLUS_PLUS, yytext()); }
"--" 		{ return new_symbol(sym.MINUS_MINUS, yytext()); }
";" 		{ return new_symbol(sym.TACKA_ZAREZ, yytext()); }
":" 		{ return new_symbol(sym.DVE_TACKE, yytext()); }
"," 		{ return new_symbol(sym.ZAREZ, yytext()); }
"." 		{ return new_symbol(sym.TACKA, yytext()); }
"(" 		{ return new_symbol(sym.LEVA_ZAGRADA, yytext()); }
")" 		{ return new_symbol(sym.DESNA_ZAGRADA, yytext()); }
"[" 		{ return new_symbol(sym.LEVA_UGLASTA_ZAGRADA, yytext()); }
"]"			{ return new_symbol(sym.DESNA_UGLASTA_ZAGRADA, yytext()); }
"{" 		{ return new_symbol(sym.LEVA_VITICASTA_ZAGRADA, yytext()); }
"}"			{ return new_symbol(sym.DESNA_VITICASTA_ZAGRADA, yytext()); }



"//" 		     { yybegin(COMMENT); }
<COMMENT> .      { yybegin(COMMENT); }
<COMMENT> "\r\n" { yybegin(YYINITIAL); }

[0-9]+  { return new_symbol(sym.NUMBER, new Integer (yytext())); }
[a-zA-Z][a-zA-Z0-9_]* 	{return new_symbol (sym.IDENT, yytext()); }

. { System.err.println("Leksicka greska ("+yytext()+") u liniji "+(yyline+1)); }



