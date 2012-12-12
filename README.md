# Export ER Model Information to standard output (API Sample)
![image](https://github.com/ChangeVision/exportERModels/raw/master/doc/screenshots/exportERModels.png)

## How to use

1. [Install Astah Plug-in SDK](http://astah.net/features/sdk)
2. clone this repository or [download the source code](https://github.com/ChangeVision/exportERModels/archive/master.zip)
3. run `astah-build`
4a. run `astah-mvn -q exec:exec -DmodelPath=YOUR_MODEL_PATH` or 
4b. run `java -cp [astah-api.jar and astah-pro.jar path] com.change_vision.astah.apisample.ERModelCSVExporter [target astah model]`

## Sample Code

src/main/java

  * com.change_vision.astah.apisample.ERModelCSVExporter - Export ER Model Information
  * com.change_vision.astah.apisample.AstahAPIWrapper - The wrapper of Astah API for error handling
  
## Note

  * This API sample is available for Astah Professional.
    
## License
Copyright 2012 Change Vision, Inc.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this work except in compliance with the License.
You may obtain a copy of the License in the LICENSE file, or at:

   <http://www.apache.org/licenses/LICENSE-2.0>

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
    
