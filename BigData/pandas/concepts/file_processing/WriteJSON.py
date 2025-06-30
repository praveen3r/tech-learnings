import pandas as pd

df = pd.DataFrame({
    'Name': ['Sachin', 'Dravid'],
    'Runs': [12000, 10000]
})

df.to_json('C:\Workspace\Learn\projects\BigData\pandas\data\Demo.json', orient='records', indent=2)

-------------------------------------------------------------------------------------------------------------------


 # Common orient Options:

orient	                Structure Type	                    Best For

'records'	        List of dicts ([{...}, {...}])	     APIs, readable output
'split'	            Dict with index, columns, data	     Dense structured data
'index'	            Dict of dicts {index: {col: val}}	 Mapping by index
'columns'	        Dict of lists {col: [val, val]}	     Per column organization
'table'	            JSON Table Schema format	         Interoperable systems

-------------------------------------------------------------------------------------------------------------------

 # Save without index

import pandas as pd

df = pd.DataFrame({
    'Name': ['Sachin', 'Dravid'],
    'Runs': [12000, 10000]
})

df.to_json('C:\Workspace\Learn\projects\BigData\pandas\data\Demo.json', orient='records', indent=2)

-------------------------------------------------------------------------------------------------------------------

 # Save to line-delimited JSON (good for logs, big data):

import pandas as pd

df = pd.DataFrame({
    'Name': ['Sachin', 'Dravid'],
    'Runs': [12000, 10000]
})

df.to_json('C:\Workspace\Learn\projects\BigData\pandas\data\Demo.jsonl', orient='records', lines=True)

-------------------------------------------------------------------------------------------------------------------

 #  Convert to JSON string (not file):

import pandas as pd

df = pd.DataFrame({
    'Name': ['Sachin', 'Dravid'],
    'Runs': [12000, 10000]
})

json_str = df.to_json(orient='records', indent=2)
print(json_str)

-------------------------------------------------------------------------------------------------------------------

 # Write nested JSON

import pandas as pd

df = pd.DataFrame({
    'Name': ['Sachin', 'Dravid'],
    'Runs': [12000, 10000],
    'Matches': [300, 250]
})

df['Stats'] = df[['Runs', 'Matches']].to_dict('records')
df_nested = df[['Name', 'Stats']]

# Write to JSON
df_nested.to_json('C:\Workspace\Learn\projects\BigData\pandas\data\Demo.json', orient='records', indent=2)

-------------------------------------------------------------------------------------------------------------------

 # Write to compressed JSON (.gz)

import pandas as pd

df = pd.DataFrame({
    'Name': ['Sachin', 'Dravid'],
    'Runs': [12000, 10000]
})

df.to_json('C:\Workspace\Learn\projects\BigData\pandas\data\players.json.gz', orient='records', compression='gzip', indent=2)


-------------------------------------------------------------------------------------------------------------------

 # Auto-name JSON file with timestamp

from datetime import datetime

df = pd.DataFrame({
    'Name': ['Sachin', 'Dravid'],
    'Runs': [12000, 10000]
})

now = datetime.now().strftime('%Y%m%d_%H%M')
filename = f'players_{now}.json'
df.to_json(filename, orient='records', indent=2)


-------------------------------------------------------------------------------------------------------------------

 # Write multiple JSON files (one per group)

import pandas as pd

df = pd.DataFrame({
    'Name': ['Sachin', 'Dravid', 'Ponting'],
    'Team': ['India', 'India', 'Australia'],
    'Runs': [12000, 10000, 11000]
})

for team, group_df in df.groupby('Team'):
    group_df.to_json(f'{team.lower()}.json', orient='records', indent=2)

-------------------------------------------------------------------------------------------------------------------

 # Save without index

import pandas as pd

df = pd.DataFrame({
    'Name': ['Sachin', 'Dravid'],
    'Runs': [12000, 10000]
})

df.to_json('players.json', orient='records', indent=2)

-------------------------------------------------------------------------------------------------------------------

 # Save without index

import pandas as pd

df = pd.DataFrame({
    'Name': ['Sachin', 'Dravid'],
    'Runs': [12000, 10000]
})

df.to_json('players.json', orient='records', indent=2)

-------------------------------------------------------------------------------------------------------------------

 # Save without index

import pandas as pd

df = pd.DataFrame({
    'Name': ['Sachin', 'Dravid'],
    'Runs': [12000, 10000]
})

df.to_json('players.json', orient='records', indent=2)

-------------------------------------------------------------------------------------------------------------------

 # Save without index

import pandas as pd

df = pd.DataFrame({
    'Name': ['Sachin', 'Dravid'],
    'Runs': [12000, 10000]
})

df.to_json('players.json', orient='records', indent=2)

-------------------------------------------------------------------------------------------------------------------

 # Save without index

import pandas as pd

df = pd.DataFrame({
    'Name': ['Sachin', 'Dravid'],
    'Runs': [12000, 10000]
})

df.to_json('players.json', orient='records', indent=2)

-------------------------------------------------------------------------------------------------------------------

 # Save without index

import pandas as pd

df = pd.DataFrame({
    'Name': ['Sachin', 'Dravid'],
    'Runs': [12000, 10000]
})

df.to_json('players.json', orient='records', indent=2)

-------------------------------------------------------------------------------------------------------------------

 # Save without index

import pandas as pd

df = pd.DataFrame({
    'Name': ['Sachin', 'Dravid'],
    'Runs': [12000, 10000]
})

df.to_json('players.json', orient='records', indent=2)

-------------------------------------------------------------------------------------------------------------------

 # Save without index

import pandas as pd

df = pd.DataFrame({
    'Name': ['Sachin', 'Dravid'],
    'Runs': [12000, 10000]
})

df.to_json('players.json', orient='records', indent=2)

-------------------------------------------------------------------------------------------------------------------

 # Save without index

import pandas as pd

df = pd.DataFrame({
    'Name': ['Sachin', 'Dravid'],
    'Runs': [12000, 10000]
})

df.to_json('players.json', orient='records', indent=2)

-------------------------------------------------------------------------------------------------------------------

 # Save without index

import pandas as pd

df = pd.DataFrame({
    'Name': ['Sachin', 'Dravid'],
    'Runs': [12000, 10000]
})

df.to_json('players.json', orient='records', indent=2)

-------------------------------------------------------------------------------------------------------------------

 # Save without index

import pandas as pd

df = pd.DataFrame({
    'Name': ['Sachin', 'Dravid'],
    'Runs': [12000, 10000]
})

df.to_json('players.json', orient='records', indent=2)

-------------------------------------------------------------------------------------------------------------------

 # Save without index

import pandas as pd

df = pd.DataFrame({
    'Name': ['Sachin', 'Dravid'],
    'Runs': [12000, 10000]
})

df.to_json('players.json', orient='records', indent=2)

-------------------------------------------------------------------------------------------------------------------

 # Save without index

import pandas as pd

df = pd.DataFrame({
    'Name': ['Sachin', 'Dravid'],
    'Runs': [12000, 10000]
})

df.to_json('players.json', orient='records', indent=2)

-------------------------------------------------------------------------------------------------------------------

 # Save without index

import pandas as pd

df = pd.DataFrame({
    'Name': ['Sachin', 'Dravid'],
    'Runs': [12000, 10000]
})

df.to_json('players.json', orient='records', indent=2)

-------------------------------------------------------------------------------------------------------------------

 # Save without index

import pandas as pd

df = pd.DataFrame({
    'Name': ['Sachin', 'Dravid'],
    'Runs': [12000, 10000]
})

df.to_json('players.json', orient='records', indent=2)

-------------------------------------------------------------------------------------------------------------------

 # Save without index

import pandas as pd

df = pd.DataFrame({
    'Name': ['Sachin', 'Dravid'],
    'Runs': [12000, 10000]
})

df.to_json('players.json', orient='records', indent=2)