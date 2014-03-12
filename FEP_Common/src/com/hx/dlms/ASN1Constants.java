/**
* @author 
*/

package com.hx.dlms;

/**
 * ASN.1 and some other constants holder interface
 * 
 * @see http://asn1.elibel.tm.fr/en/standards/index.htm
 */
public interface ASN1Constants {
    /**
     * Tag classes
     */
    int CLASS_UNIVERSAL = 0;
    int CLASS_APPLICATION = 64;
    int CLASS_CONTEXTSPECIFIC = 128;
    int CLASS_PRIVATE = 192;

    /**
     * Tag Primitive/Constructed (P/C) flag
     */
    int PC_PRIMITIVE = 0;
    int PC_CONSTRUCTED = 32;

    /**
     * Universal class tag assignments
     */
    int TAG_BOOLEAN = 1;
    int TAG_INTEGER = 2;
    int TAG_BITSTRING = 3;
    int TAG_OCTETSTRING = 4;
    int TAG_NULL = 5;
    int TAG_OID = 6;
    int TAG_OBJDESCRIPTOR = 7;
    int TAG_EXTERNAL = 8;
    int TAG_INSTANCEOF = TAG_EXTERNAL;
    int TAG_REAL = 9;
    int TAG_ENUM = 10;
    int TAG_EMBEDDEDPDV = 11;
    int TAG_UTF8STRING = 12;
    int TAG_RELATIVEOID = 13;
    int TAG_SEQUENCE = 16;
    int TAG_SEQUENCEOF = TAG_SEQUENCE;
    int TAG_SET = 17;
    int TAG_SETOF = TAG_SET;
    int TAG_NUMERICSTRING = 18;
    int TAG_PRINTABLESTRING = 19;
    int TAG_TELETEXSTRING = 20;
    int TAG_T61STRING = TAG_TELETEXSTRING;
    int TAG_VIDEOTEXSTRING = 21;
    int TAG_IA5STRING = 22;
    int TAG_UTCTIME = 23;
    int TAG_GENERALIZEDTIME = 24;
    int TAG_GRAPHICSTRING = 25;
    int TAG_VISIBLESTRING = 26;
    int TAG_ISO646STRING = TAG_VISIBLESTRING;
    int TAG_GENERALSTRING = 27;
    int TAG_UNIVERSALSTRING = 28;
    int TAG_BMPSTRING = 30;

    int TAG_C_BITSTRING = TAG_BITSTRING | PC_CONSTRUCTED;
    int TAG_C_OCTETSTRING = TAG_OCTETSTRING | PC_CONSTRUCTED;
    int TAG_C_UTF8STRING = TAG_UTF8STRING | PC_CONSTRUCTED;
    int TAG_C_SEQUENCE = TAG_SEQUENCE | PC_CONSTRUCTED;
    int TAG_C_SEQUENCEOF = TAG_SEQUENCEOF | PC_CONSTRUCTED;
    int TAG_C_SET = TAG_SET | PC_CONSTRUCTED;
    int TAG_C_SETOF = TAG_SETOF | PC_CONSTRUCTED;
    int TAG_C_UTCTIME = TAG_UTCTIME | PC_CONSTRUCTED;
    int TAG_C_GENERALIZEDTIME = TAG_GENERALIZEDTIME | PC_CONSTRUCTED;
 
    /**
     * Not from the ASN.1 specs. For implementation purposes.
     */
    int TAG_ANY = 0;
    int TAG_CHOICE = TAG_ANY;
    
    int BER_CODEC = 0;
    int DER_CODEC = 1;
    int AXDR_CODEC = 2; 

	static int DEFAULT_CODEC = AXDR_CODEC;
}
