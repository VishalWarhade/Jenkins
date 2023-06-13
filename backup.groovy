pipelineJob('pipeline1_converted') {
  
  description('')
  
  displayName('pipeline1_converted')
  
  keepDependencies(false)
  
  quietPeriod(0)
  
//   checkoutRetryCount(0)
  
  disabled(false)
  
//   concurrentBuild(false)
  
  configure { flowdefinition ->
    
    flowdefinition / 'actions' << 'org.jenkinsci.plugins.pipeline.modeldefinition.actions.DeclarativeJobAction'(plugin:'pipeline-model-definition')
    
    flowdefinition / 'actions' << 'org.jenkinsci.plugins.pipeline.modeldefinition.actions.DeclarativeJobPropertyTrackerAction'(plugin:'pipeline-model-definition') {
      
      'jobProperties'()
      
      'triggers'()
      
      'parameters'()
      
      'options'()
      
    }
    
    flowdefinition << delegate.'definition'(class:'org.jenkinsci.plugins.workflow.cps.CpsScmFlowDefinition',plugin:'workflow-cps') {
      
      'scm'(class:'hudson.plugins.git.GitSCM',plugin:'git') {
        
        'configVersion'(2)
        
        'userRemoteConfigs' {
          
          'hudson.plugins.git.UserRemoteConfig' {
            
            'url'('https://github.com/VishalWarhade/Jenkins.git')
            
          }
          
        }
        
        'branches' {
          
          'hudson.plugins.git.BranchSpec' {
            
            'name'('*/main')
            
          }
          
        }
        
        'doGenerateSubmoduleConfigurations'(false)
        
        'submoduleCfg'(class:'empty-list')
        
        'extensions'()
        
      }
      
      'scriptPath'('fullpipeline.groovy')
      
      'lightweight'(true)
      
    }
    
  }
  
}
