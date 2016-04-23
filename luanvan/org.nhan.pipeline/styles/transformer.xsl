<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/">
<html>
  <head>
    <title>Sample page</title>
  </head>
  <body>
    <xsl:for-each select="result/node">
        <number><xsl:value-of select="."/></number>
    </xsl:for-each>
  </body>
</html>
</xsl:template>
</xsl:stylesheet>
