// Declaring class to store data related to climate action 
class ClimateActionData {
	// Setting properties to store various pieces of information
	var name: String? = null
	var description: String? = null
	var targetDate: String? = null
	
	// Initialising class constructor 
	constructor(name: String, description: String, targetDate: String) {
		this.name = name
		this.description = description
		this.targetDate = targetDate
	}
}

// Declaring interface to define functions for climate action
interface ClimateAction {
		// Function to get a list of climate action targets
		fun getTargets() : List<ClimateActionData>
	
		// Function to add a new climate action target
		fun addTarget(name: String, description: String, targetDate: String)
	
		// Function to delete a climate action target
		fun deleteTarget(name: String)
		
		// Function to update a climate action target
		fun updateTarget(name: String, description: String, targetDate: String)
}

// Implementing the ClimateAction interface in ClimateActionImpl class 
class ClimateActionImpl : ClimateAction {
	// Setting property to store the list of climate action targets
	var targets: MutableList<ClimateActionData>? = null
	
	// Initialising class constructor 
	constructor() {
		targets = mutableListOf()
	}
	
	// Function to get a list of climate action targets 
	override fun getTargets(): List<ClimateActionData> {
		return targets!!
	}
	
	// Function to add a new climate action target
	override fun addTarget(name: String, description: String, targetDate: String) {
		val newTarget = ClimateActionData(name, description, targetDate)
		targets!!.add(newTarget)
	}
	
	// Function to delete a climate action target
	override fun deleteTarget(name: String) {
		val targetToDelete = targets!!.find { it.name == name }
		targets!!.remove(targetToDelete)
	}
	
	// Function to update a climate action target
	override fun updateTarget(name: String, description: String, targetDate: String) {
		val targetToUpdate = targets!!.find { it.name == name }
		if (targetToUpdate != null) {
			targetToUpdate.description = description
			targetToUpdate.targetDate = targetDate
		}
	}
}

// Declaring Main class
class ClimateActionMain {
	companion object {
		@JvmStatic
		fun main(args: Array<String>) {
			// Creating instance of ClimateActionImpl class
			val climateAction = ClimateActionImpl()
			
			// Adding a new target
			climateAction.addTarget("Reduce emissions", 
									"reduce carbon emissions to net-zero by 2050", 
									"2050")
			
			// Updating a target
			climateAction.updateTarget("Reduce emissions", 
									   "reduce all types of greenhouse gas emissions to net-zero by 2050", 
									   "2050")
			
			// Deleting a target
			climateAction.deleteTarget("Reduce emissions")
			
			// Getting a list of targets
			val targets = climateAction.getTargets()
			targets.forEach {
				println("Name: ${it.name}, Description: ${it.description}, Target Date: ${it.targetDate}")
			}
		}
	}
}