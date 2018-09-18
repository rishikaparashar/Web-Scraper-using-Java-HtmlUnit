import java.math.BigDecimal;

public class Item {
	private String PlacardTitle;
	private String PlacardHref;
	private String Location;
	private java.util.List<String> ImageUrl;
	private BigDecimal PriceRange;
	
	public String getPlacardTitle()
	{
		return PlacardTitle;
	}
	
	public void setPlacardTitle(String placardTitle)
	{
		this.PlacardTitle = placardTitle;
	}
	
	public String getPlacardHref()
	{
		return PlacardHref;
	}
	
	public void setPlacardHref(String placardHref)
	{
		this.PlacardHref = placardHref;
	}
	
	public String getLocation()
	{
		return Location;
	}
	
	public void setLocation(String location)
	{
		this.Location = location;
	}
	
	public java.util.List<String> getImageUrl()
	{
		return ImageUrl;
	}
	
	public void setImageUrl(java.util.List<String> imageList)
	{
		this.ImageUrl = imageList;
	}
	
	public BigDecimal getPriceRange()
	{
		return PriceRange;
	}

	public void setPriceRange(BigDecimal priceRange)
	{
		this.PriceRange = priceRange;
	}
}
