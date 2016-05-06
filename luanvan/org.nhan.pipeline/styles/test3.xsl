<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/">
	<result>
		<xsl:for-each select="result/call">
			<xsl:if test=".">
			<number><xsl:value-of select="id"/></number>
			</xsl:if>
        	
    	</xsl:for-each>
	</result>	
</xsl:template>
</xsl:stylesheet>

