package decode.p25.message.ldu;

import alias.AliasList;
import bits.BitSetBuffer;
import decode.p25.message.P25Message;
import decode.p25.reference.DataUnitID;
import edac.CRC;

public class LDUMessage extends P25Message
{
	public LDUMessage( BitSetBuffer message, DataUnitID duid,
            AliasList aliasList )
    {
	    super( message, duid, aliasList );

	    /* NID CRC is checked in the message framer, thus a constructed message
	     * means it passed the CRC */
	    mCRC = new CRC[ 2 ];
	    mCRC[ 0 ] = CRC.PASSED;
    }
	
	@Override
    public String getMessage()
    {
		StringBuilder sb = new StringBuilder();
		
		sb.append( "NAC:" );
		sb.append( getNAC() );
		sb.append( " " );
		sb.append( getDUID().getLabel() );
		sb.append( " " );
		
		sb.append( mMessage.toString() );
		
	    return sb.toString();
    }
	
	/* Temporary override */
	public boolean isValid()
	{
		return true;
	}

}