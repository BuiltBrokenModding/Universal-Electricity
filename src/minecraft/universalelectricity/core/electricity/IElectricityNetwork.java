package universalelectricity.core.electricity;

import java.util.HashMap;
import java.util.List;

import net.minecraft.tileentity.TileEntity;
import universalelectricity.core.block.IConductor;

/**
 * The Electrical Network in interface form.
 * 
 * @author Calclavia
 * 
 */
public interface IElectricityNetwork
{
	/**
	 * Sets this TileEntity to start producing energy in this network.
	 */
	public void startProducing(TileEntity tileEntity, ElectricityPack electricityPack);

	public void startProducing(TileEntity tileEntity, double amperes, double voltage);

	/**
	 * Is this TileEntity producing electricity?
	 */
	public boolean isProducing(TileEntity tileEntity);

	/**
	 * Stops the TileEntity from producing electricity.
	 */
	public void stopProducing(TileEntity tileEntity);

	/**
	 * Sets a TileEntity to start requesting electricity from the network.
	 */
	public void startRequesting(TileEntity tileEntity, ElectricityPack electricityPack);

	public void startRequesting(TileEntity tileEntity, double amperes, double voltage);

	/**
	 * Is this TileEntity requesting electricity?
	 */
	public boolean isRequesting(TileEntity tileEntity);

	/**
	 * Stops the TileEntity from requesting electricity from the network.
	 */
	public void stopRequesting(TileEntity tileEntity);

	/**
	 * Gets the total amount of electricity produced in the electricity network.
	 * 
	 * @param ignoreTiles The TileEntities to ignore during this calculation (optional).
	 */
	public ElectricityPack getProduced(TileEntity... ignoreTiles);

	/**
	 * Gets the total amount of electricity requested in the electricity network. Takes account of
	 * electricity being produced in the network.
	 * 
	 * @param ignoreTiles The TileEntities to ignore during this calculation (optional).
	 */
	public ElectricityPack getRequest(TileEntity... ignoreTiles);

	/**
	 * Gets the total amount of electricity requested WITHOUT accounting in the electricity already
	 * being produced.
	 */
	public ElectricityPack getRequestWithoutReduction();

	/**
	 * Attemps to consume electricity for this TileEntity based on what was requested.
	 * 
	 * @return The actual amount of electricity consumed.
	 */
	public ElectricityPack consumeElectricity(TileEntity tileEntity);

	/**
	 * @return Gets a list of TileEntities currently producing electricity in the network.
	 * 
	 */
	public HashMap<TileEntity, ElectricityPack> getProducers();

	public List<TileEntity> getProviders();

	/**
	 * @return Gets a list of TileEntities currently receiving electricity from the network.
	 * 
	 */
	public HashMap<TileEntity, ElectricityPack> getConsumers();

	public List<TileEntity> getReceivers();

	/**
	 * @return A list of all conductors in this electrical network.
	 */
	public List<IConductor> getConductors();

	/**
	 * @return The total amount of resistance of this electrical network. In Ohms.
	 */
	public double getTotalResistance();

	/**
	 * @return The lowest amount of current (amperage) that this electrical network can tolerate.
	 */
	public double getLowestCurrentCapacity();

	/**
	 * Merges another electrical network into this one, setting the other network into null.
	 * 
	 * @param network
	 */
	public void mergeConnection(IElectricityNetwork network);

	/**
	 * Refreshes and recalculates wire connections in this electrical network.
	 * 
	 * @param doSplit - True if check for connection splits.
	 */
	public void refreshConductors(boolean doSplit);

	/**
	 * Registers a conductor to the electricity network.
	 */
	public void registerConductor(IConductor newConductor);

	/**
	 * Cleans up and updates the list of conductors in the electricity network.
	 */
	public void cleanConductors();

	/**
	 * Resets all conductors in this electricity network and recalculate all connections.
	 */
	public void resetConductors();

}
