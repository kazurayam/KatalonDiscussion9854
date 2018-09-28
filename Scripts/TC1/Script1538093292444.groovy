import internal.GlobalVariable as GlobalVariable

Map memory = (Map)GlobalVariable.MEMORY
CustomKeywords.'my.MemoryManager.retrieve'(memory)

memory.put('A', "TC1 said hello")

