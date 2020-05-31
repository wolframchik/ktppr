import java.util.HashMap;



public class AStarState
	
{
	private Map2D map;
	private HashMap<Location, Waypoint> openWaypoints;
	private HashMap<Location, Waypoint> closeWaypoints;
	public AStarState(Map2D map)

		{
		if (map == null)
			throw new NullPointerException("map cannot 0");
		this.map = map;
		openWaypoints = new HashMap<Location, Waypoint>();
		closeWaypoints = new HashMap<Location, Waypoint>();
		}
	public Map2D getMap()
		{

		return map;
		}
	public Waypoint getMinOpenWaypoint()
		{
		Waypoint minWp = null;
		float min = Float.POSITIVE_INFINITY;
		for (Waypoint wp: openWaypoints.values())
			{

			float cost = wp.getTotalCost();
			if (cost < min)
				{

				min = cost;
				minWp = wp;
				}

			}


		return minWp;
		}
	public boolean addOpenWaypoint(Waypoint newWP)
		{
		Waypoint openWP = openWaypoints.get(newWP.loc);


		if (openWP == null || newWP.getPreviousCost() < openWP.getPreviousCost())
			{
			openWaypoints.put(newWP.loc, newWP);


			return true;
			}
		return false;
		}




	public int numOpenWaypoints()
		{
		return openWaypoints.size();

		}
	public void closeWaypoint(Location loc)
		{
		Waypoint openWP = openWaypoints.remove(loc);
		if (openWP != null)
			{
			closeWaypoints.put(loc, openWP);
			}

		}
	public boolean isLocationClosed(Location loc)
		{
		return closeWaypoints.containsKey(loc);
		}
	
}