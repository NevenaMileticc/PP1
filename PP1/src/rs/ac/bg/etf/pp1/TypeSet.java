package rs.ac.bg.etf.pp1;

import rs.etf.pp1.symboltable.concepts.Struct;

public class TypeSet extends Struct {

	public static final int Set = 8;
	
	
	public TypeSet(int kind) {
		super(kind);
	}
	
	
	@Override
	public boolean equals(Struct other) {
		return other.getKind() == TypeSet.Set;
	}
	
}
