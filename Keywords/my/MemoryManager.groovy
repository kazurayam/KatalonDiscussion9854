package my

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI


class MemoryManager {
	
	/**
	 * Refresh browser
	 */
	@Keyword
	def remember(Map memory) {
		StringBuilder sb = new StringBuilder()
		Set keyset = new TreeSet(memory.keySet())
		for (Iterator keyIter = keyset.iterator(); keyIter.hasNext();) {
			def key = (String)keyIter.next()
			sb.append("key=${key},value=${memory.get(key)}\n")
		}
		WebUI.comment(sb.toString())
	}
}