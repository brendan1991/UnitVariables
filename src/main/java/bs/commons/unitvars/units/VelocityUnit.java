package bs.commons.unitvars.units;

import bs.commons.unitvars.core.UnitConversionMap;
import bs.commons.unitvars.core.UnitGroup;
import bs.commons.unitvars.core.UnitType;
import bs.commons.unitvars.core.UnitData.Unit;

public enum VelocityUnit implements Unit
{
	NANOMETERS_PER_SECOND(
		"Nanometers per Second",
		"nm/s"),
	MICROMETERS_PER_SECOND(
		"Micrometers per Second",
		"um/s"),
	MILLIMETERS_PER_SECOND(
		"Millimeters per Second",
		"mm/s"),
	METERS_PER_SECOND(
		"Meters per Second",
		"m/s"),
	KILOMETERS_PER_SECOND(
		"Kilometers per Second",
		"km/s");

	private VelocityUnit(String unit_name, String unit_abbreviation)
	{
		Unit.newUnitDetails(unit_name, unit_abbreviation, this, UnitType.VELOCITY);

	}

	@Override
	public UnitConversionMap getConversionMap()
	{

		UnitConversionMap map = new UnitConversionMap();
		for (VelocityUnit unit : VelocityUnit.values())
		{
			map.addConversions(unit, getDistanceConversionArray(unit.ordinal()));
		}
		return map;
	}

	public Double[] getDistanceConversionArray(Integer multiplier_index)
	{
		Double[] conversions = new Double[VelocityUnit.values().length];
		for (Integer place = 0; place < conversions.length; place++)
		{
			conversions[place] = Math.pow(10, -(place - 3) * 3);
		}

		return conversions;
	}

	@Override
	public UnitGroup getGroup()
	{
		return UnitType.VELOCITY;
	}

}
