import pandas as pd

df = pd.read_json('C:\Workspace\Learn\projects\BigData\pandas\data\Test.json')
print(df)

--------------------------------------------------------------------------------------------

# Parameters you can use:

Parameter	                Purpose

orient	            Specify JSON format: records, split, index, etc.
lines=True	        For line-delimited JSON (.jsonl)
dtype	            Force specific data types

---------------------------------------------------------------------------------------------


# Read JSON from string

import pandas as pd

df = pd.read_json('C:\Workspace\Learn\projects\BigData\pandas\data\Test.json')
print(df)

--------------------------------------------------------------------------------------------

# Read JSON from string

import pandas as pd

df = pd.read_json('C:\Workspace\Learn\projects\BigData\pandas\data\Test.json')
print(df)

--------------------------------------------------------------------------------------------

# nested dictionaries

import pandas as pd
from pandas import json_normalize

import json
with open('C:\Workspace\Learn\projects\BigData\pandas\data\Test.json') as f:
    data = json.load(f)

df = json_normalize(data)
--------------------------------------------------------------------------------------------

#  Read line-delimited JSON (e.g., logs):

import pandas as pd

df = pd.read_json('log.jsonl', lines=True)

print(df)

--------------------------------------------------------------------------------------------

# Read nested JSON and flatten it

import json
import pandas as pd
from pandas import json_normalize

with open('C:\Workspace\Learn\projects\BigData\pandas\data\Nested.json') as f:
    data = json.load(f)

df = json_normalize(data)
print(df)

--------------------------------------------------------------------------------------------

# Handle multi-level nested JSON

import json
import pandas as pd
from pandas import json_normalize

with open('C:\Workspace\Learn\projects\BigData\pandas\data\Nested.json') as f:
    data = json.load(f)

df = json_normalize(data, sep='_')  # Replaces dots with underscores
print(df)

--------------------------------------------------------------------------------------------

# Save back to JSON after editing

import pandas as pd

df = pd.read_json('C:\Workspace\Learn\projects\BigData\pandas\data\Test.json')

df.to_json('C:\Workspace\Learn\projects\BigData\pandas\data\updated.json', orient='records', indent=2)


print(df)

--------------------------------------------------------------------------------------------

# Read JSON from string

import pandas as pd

df = pd.read_json('C:\Workspace\Learn\projects\BigData\pandas\data\Test.json')
print(df)

--------------------------------------------------------------------------------------------

# Read JSON from string

import pandas as pd

df = pd.read_json('C:\Workspace\Learn\projects\BigData\pandas\data\Test.json')
print(df)

--------------------------------------------------------------------------------------------

# Read JSON from string

import pandas as pd

df = pd.read_json('C:\Workspace\Learn\projects\BigData\pandas\data\Test.json')
print(df)

--------------------------------------------------------------------------------------------

# Read JSON from string

import pandas as pd

df = pd.read_json('C:\Workspace\Learn\projects\BigData\pandas\data\Test.json')
print(df)

--------------------------------------------------------------------------------------------

# Read JSON from string

import pandas as pd

df = pd.read_json('C:\Workspace\Learn\projects\BigData\pandas\data\Test.json')
print(df)

--------------------------------------------------------------------------------------------

# Read JSON from string

import pandas as pd

df = pd.read_json('C:\Workspace\Learn\projects\BigData\pandas\data\Test.json')
print(df)

--------------------------------------------------------------------------------------------

# Read JSON from string

import pandas as pd

df = pd.read_json('C:\Workspace\Learn\projects\BigData\pandas\data\Test.json')
print(df)

--------------------------------------------------------------------------------------------

# Read JSON from string

import pandas as pd

df = pd.read_json('C:\Workspace\Learn\projects\BigData\pandas\data\Test.json')
print(df)

--------------------------------------------------------------------------------------------

# Read JSON from string

import pandas as pd

df = pd.read_json('C:\Workspace\Learn\projects\BigData\pandas\data\Test.json')
print(df)

--------------------------------------------------------------------------------------------

# Read JSON from string

import pandas as pd

df = pd.read_json('C:\Workspace\Learn\projects\BigData\pandas\data\Test.json')
print(df)

--------------------------------------------------------------------------------------------

# Read JSON from string

import pandas as pd

df = pd.read_json('C:\Workspace\Learn\projects\BigData\pandas\data\Test.json')
print(df)

--------------------------------------------------------------------------------------------

# Read JSON from string

import pandas as pd

df = pd.read_json('C:\Workspace\Learn\projects\BigData\pandas\data\Test.json')
print(df)

--------------------------------------------------------------------------------------------

# Read JSON from string

import pandas as pd

df = pd.read_json('C:\Workspace\Learn\projects\BigData\pandas\data\Test.json')
print(df)

--------------------------------------------------------------------------------------------

# Read JSON from string

import pandas as pd

df = pd.read_json('C:\Workspace\Learn\projects\BigData\pandas\data\Test.json')
print(df)

--------------------------------------------------------------------------------------------

# Read JSON from string

import pandas as pd

df = pd.read_json('C:\Workspace\Learn\projects\BigData\pandas\data\Test.json')
print(df)

--------------------------------------------------------------------------------------------

# Read JSON from string

import pandas as pd

df = pd.read_json('C:\Workspace\Learn\projects\BigData\pandas\data\Test.json')
print(df)

--------------------------------------------------------------------------------------------

# Read JSON from string

import pandas as pd

df = pd.read_json('C:\Workspace\Learn\projects\BigData\pandas\data\Test.json')
print(df)

--------------------------------------------------------------------------------------------

# Read JSON from string

import pandas as pd

df = pd.read_json('C:\Workspace\Learn\projects\BigData\pandas\data\Test.json')
print(df)

--------------------------------------------------------------------------------------------

# Read JSON from string

import pandas as pd

df = pd.read_json('C:\Workspace\Learn\projects\BigData\pandas\data\Test.json')
print(df)

--------------------------------------------------------------------------------------------

# Read JSON from string

import pandas as pd

df = pd.read_json('C:\Workspace\Learn\projects\BigData\pandas\data\Test.json')
print(df)

--------------------------------------------------------------------------------------------

# Read JSON from string

import pandas as pd

df = pd.read_json('C:\Workspace\Learn\projects\BigData\pandas\data\Test.json')
print(df)

--------------------------------------------------------------------------------------------

# Read JSON from string

import pandas as pd

df = pd.read_json('C:\Workspace\Learn\projects\BigData\pandas\data\Test.json')
print(df)

--------------------------------------------------------------------------------------------

# Read JSON from string

import pandas as pd

df = pd.read_json('C:\Workspace\Learn\projects\BigData\pandas\data\Test.json')
print(df)

--------------------------------------------------------------------------------------------

# Read JSON from string

import pandas as pd

df = pd.read_json('C:\Workspace\Learn\projects\BigData\pandas\data\Test.json')
print(df)

--------------------------------------------------------------------------------------------

# Read JSON from string

import pandas as pd

df = pd.read_json('C:\Workspace\Learn\projects\BigData\pandas\data\Test.json')
print(df)

--------------------------------------------------------------------------------------------

# Read JSON from string

import pandas as pd

df = pd.read_json('C:\Workspace\Learn\projects\BigData\pandas\data\Test.json')
print(df)

--------------------------------------------------------------------------------------------

# Read JSON from string

import pandas as pd

df = pd.read_json('C:\Workspace\Learn\projects\BigData\pandas\data\Test.json')
print(df)

--------------------------------------------------------------------------------------------

# Read JSON from string

import pandas as pd

df = pd.read_json('C:\Workspace\Learn\projects\BigData\pandas\data\Test.json')
print(df)

--------------------------------------------------------------------------------------------

# Read JSON from string

import pandas as pd

df = pd.read_json('C:\Workspace\Learn\projects\BigData\pandas\data\Test.json')
print(df)

--------------------------------------------------------------------------------------------

# Read JSON from string

import pandas as pd

df = pd.read_json('C:\Workspace\Learn\projects\BigData\pandas\data\Test.json')
print(df)

