package br.org.curitiba.ici.gtm.type;

import java.util.Arrays;

import io.quarkus.panache.common.Sort.Direction;

public enum OrderDirection {
	 ASCENDING("asc", Direction.Ascending),
     DESCENDING("desc", Direction.Descending);
	
	
	
	private String directionString;
	private Direction directionPanache;

	OrderDirection(String directionString, Direction directionPanache) {
		this.directionString = directionString;
		this.directionPanache = directionPanache;
	}

	public static OrderDirection fromString(final String directionString) {
		return
			Arrays.stream(OrderDirection.values())
			.filter(direction -> direction.directionString.equalsIgnoreCase(directionString))
			.findAny()
			.orElse(DESCENDING);
	}

	public Direction toPanacheDirection() {
		return this.directionPanache;
	}
}
