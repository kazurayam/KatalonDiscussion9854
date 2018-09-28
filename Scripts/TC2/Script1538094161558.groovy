import internal.GlobalVariable as GlobalVariable

Map memory = (Map)GlobalVariable.MEMORY
CustomKeywords.'my.MemoryManager.retrieve'(memory)

memory.put('B', "TC2 said welcome")

GlobalVariable.MEMORY = memory
