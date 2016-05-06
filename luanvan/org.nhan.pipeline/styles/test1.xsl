<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/">
	<html>
	<result>
		<xsl:for-each select="result/call">
        	<number><xsl:value-of select="id"/></number>
    	</xsl:for-each>
	</result>	
	</html>
</xsl:template>
</xsl:stylesheet>
