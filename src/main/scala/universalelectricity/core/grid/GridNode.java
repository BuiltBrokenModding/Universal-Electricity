package universalelectricity.core.grid;

import net.minecraftforge.common.util.ForgeDirection;
import universalelectricity.api.core.grid.IGridNode;

import java.util.Map;

/**
 * Created by robert on 8/13/2014.
 */
public class GridNode<N extends Node> extends Grid<N>
{
    public GridNode(Class node)
    {
        super(node);
    }

    @Override
    protected void reconstructNode(N node)
    {
        node.reconstruct();
        if(node instanceof IGridNode)
            ((IGridNode)node).setGrid(this);
    }

    @Override
    public void deconstruct()
    {
        for(N node : getNodes())
        {
            if(node instanceof IGridNode)
                ((IGridNode)node).setGrid(null);
            node.reconstruct();
        }
        super.deconstruct();
    }
}