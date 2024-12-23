import java.awt.Color;
import java.io.IOException;

public class PlotDemo {
	public static void main(String[] args) throws IOException {
		Plot plot = Plot.plot(Plot.plotOpts().
								width(800).
								height(800).
								legend(Plot.LegendFormat.BOTTOM)).	
							xAxis("x", Plot.axisOpts().
								range(-10, 10)).
							yAxis("y", Plot.axisOpts().
								range(-10, 10)).
							series("LINE 1 : 5x+3y=10", Plot.data().
								xy(-10.0, 5).
								xy(10.0, 5),
								Plot.seriesOpts().
									line(Plot.Line.SOLID).
									color(Color.BLACK).
									marker(Plot.Marker.DIAMOND).
									markerColor(Color.RED).
									markerSize(5)).
							series("LINE 2 : 7x-9y=2", Plot.data().
									xy(-10.0, (7/9.0)*(-10)-(2/9.0)).
									xy(10.0,(7/9.0)*(10)-(2/9.0)),
									Plot.seriesOpts().
										line(Plot.Line.SOLID).
										color(Color.BLUE).
										marker(Plot.Marker.BAR).
										markerColor(Color.RED).
										markerSize(5)).
							series("Intersection", Plot.data().
										xy(1.455,0.909),
										Plot.seriesOpts().
											line(Plot.Line.NONE).
											color(Color.BLACK).
											marker(Plot.Marker.BAR).
											markerColor(Color.RED).
											markerSize(12));

						plot.save("Demo2", "png");

						System.out.println((7/9.0)*(10)-(2/9.0));
	}


}